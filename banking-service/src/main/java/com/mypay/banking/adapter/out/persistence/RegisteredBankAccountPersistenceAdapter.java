package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.domain.RegisterBankAccount;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;


    @Override
    public RegisteredBankAccountJpaEntity createRegisterBankAccount(RegisterBankAccount registerBankAccount) {
        return registeredBankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        registerBankAccount.getMembershipId(),
                        registerBankAccount.getBankName(),
                        registerBankAccount.getBankAccountNumber(),
                        registerBankAccount.isLinkedStatusIsValid()
                )
        );
    }
}
