package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.mypay.banking.adapter.out.external.bank.FirmbankingResult;
import com.mypay.banking.adapter.out.persistence.RequestFirmbankingJpaEntity;
import com.mypay.banking.adapter.out.persistence.RequestFirmbankingMapper;
import com.mypay.banking.application.port.in.RequestFirmbankingCommand;
import com.mypay.banking.application.port.in.RequestFirmbankingUseCase;
import com.mypay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.mypay.banking.application.port.out.RequestFirmbankingPort;
import com.mypay.banking.domain.FirmbankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

    private final RequestFirmbankingPort requestFirmbankingPort;

    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    private final RequestFirmbankingMapper requestFirmbankingMapper;

    @Override
    public FirmbankingRequest requestFirmbanking (RequestFirmbankingCommand command) {

        // biz logic
        // a -> b 계좌


        // 1. 요청에 대해 정보를 먼저 write. "요청" 상태로
        RequestFirmbankingJpaEntity requestFirmbankingJpaEntity = requestFirmbankingPort.createRequestFirmbanking(
                FirmbankingRequest.builder()
                        .fromBankName(command.getFromBankName())
                        .fromBankAccountNumber(command.getFromBankAccountNumber())
                        .toBankName(command.getToBankName())
                        .toBankAccountNumber(command.getToBankAccountNumber())
                        .moneyAmount(command.getMoneyAmount())
                        .firmbankingStatus(0)
                        .build()
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult firmbankingResult = requestExternalFirmbankingPort
                .requestExternalFirmbanking(new ExternalFirmbankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber()
        ));

        // Transactional UUID
        UUID randomUUID = UUID.randomUUID();
        requestFirmbankingJpaEntity.setUuid(randomUUID);

        // 3. 결과에 따라서 1번에서 작성했던 FirmbankingRequest 정보를 Update
        if (firmbankingResult.getResultCode() == 0){
            requestFirmbankingJpaEntity.setFirmbankingStatus(1);
        } else {
            requestFirmbankingJpaEntity.setFirmbankingStatus(2);
        }

        // 4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
        return requestFirmbankingMapper.mapToDomain(
                requestFirmbankingPort.modifyRequestFirmbanking(requestFirmbankingJpaEntity), randomUUID);
    }
}
