package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

    public RegisterBankAccount mapToDomain(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {
        return RegisterBankAccount.builder()
                .registerBankAccountId(registeredBankAccountJpaEntity.getRegisterBankAccountId())
                .membershipId(registeredBankAccountJpaEntity.getMembershipId())
                .bankName(registeredBankAccountJpaEntity.getBankName())
                .bankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber())
                .linkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
                .build();
    }
}
