package com.mypay.banking.application.port.in;

import com.mypay.banking.domain.FirmbankingRequest;
import com.mypay.common.UseCase;

@UseCase
public interface RequestFirmbankingUseCase {

    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
