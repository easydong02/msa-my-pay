package com.mypay.banking.application.port.out;


import com.mypay.banking.adapter.out.persistence.RequestFirmbankingJpaEntity;
import com.mypay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingPort {

    RequestFirmbankingJpaEntity createRequestFirmbanking(FirmbankingRequest firmbankingRequest);

    RequestFirmbankingJpaEntity modifyRequestFirmbanking(RequestFirmbankingJpaEntity entity);
}
