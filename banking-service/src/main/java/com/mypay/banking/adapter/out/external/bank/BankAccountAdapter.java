package com.mypay.banking.adapter.out.external.bank;

import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.mypay.common.ExternalSystem;
import lombok.RequiredArgsConstructor;

@ExternalSystem
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmbankingPort {

    /**
     *
     * 외부의 은행 계좌 정보를 가져온다
     * @param request
     * @return BankAccount
     */
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        return new BankAccount(request.getBankName(), request.getAccountNumber(), true);
    }


    /**
     * 실제로 외부은행에 통신을 통해서 펌뱅킹 요청을 하고
     * 그 결과를 외부 은행의 실제 결과를 -> 나의 페이의 FirmbankingResult 파싱
     */
    @Override
    public FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest externalFirmbankingRequest) {

        return new FirmbankingResult(0);
    }
}
