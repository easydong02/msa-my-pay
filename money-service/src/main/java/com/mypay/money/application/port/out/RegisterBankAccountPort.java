package com.mypay.money.application.port.out;


import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mypay.banking.domain.RegisterBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisterBankAccount(RegisterBankAccount registerBankAccount);
}
