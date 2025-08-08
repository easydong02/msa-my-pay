package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.application.port.out.RequestFirmbankingPort;
import com.mypay.banking.domain.FirmbankingRequest;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestFirmbankingPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataRequestFirmbankingRepository requestFirmbankingRepository;

    @Override
    public RequestFirmbankingJpaEntity createRequestFirmbanking(FirmbankingRequest firmbankingRequest) {
        return requestFirmbankingRepository.save(new RequestFirmbankingJpaEntity(
                firmbankingRequest.getFromBankName(),
                firmbankingRequest.getFromBankAccountNumber(),
                firmbankingRequest.getToBankName(),
                firmbankingRequest.getToBankAccountNumber(),
                firmbankingRequest.getMoneyAmount(),
                firmbankingRequest.getFirmbankingStatus(),
                UUID.randomUUID()
        ));
    }

    @Override
    public RequestFirmbankingJpaEntity modifyRequestFirmbanking(RequestFirmbankingJpaEntity entity) {
        return requestFirmbankingRepository.save(entity);
    }
}
