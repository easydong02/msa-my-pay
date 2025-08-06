package com.mypay.banking.adapter.out.external.bank;

import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mypay.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.domain.RegisterBankAccount;
import com.mypay.common.ExternalSystem;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystem
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

//    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        return new BankAccount(request.getBankName(), request.getAccountNumber(), true);
    }
}
