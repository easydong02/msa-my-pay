package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.domain.FirmbankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestFirmbankingMapper {

    public FirmbankingRequest mapToDomain(RequestFirmbankingJpaEntity requestFirmbankingJpaEntity, UUID uuid) {
        return FirmbankingRequest.builder()
                .firmbankingRequestId(requestFirmbankingJpaEntity.getRequestFirmbankingId())
                .fromBankName(requestFirmbankingJpaEntity.getFromBankName())
                .fromBankAccountNumber(requestFirmbankingJpaEntity.getFromBankAccountNumber())
                .toBankName(requestFirmbankingJpaEntity.getToBankName())
                .toBankAccountNumber(requestFirmbankingJpaEntity.getToBankAccountNumber())
                .moneyAmount(requestFirmbankingJpaEntity.getMoneyAmount())
                .firmbankingStatus(requestFirmbankingJpaEntity.getFirmbankingStatus())
                .uuid(uuid)
                .build();
    }
}
