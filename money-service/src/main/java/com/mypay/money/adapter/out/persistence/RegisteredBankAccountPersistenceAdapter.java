package com.mypay.money.adapter.out.persistence;

import com.mypay.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.domain.RegisterBankAccount;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;


    @Override
    public MoneyChangingRequestJpaEntity createRegisterBankAccount(RegisterBankAccount registerBankAccount) {
        return registeredBankAccountRepository.save(
                new MoneyChangingRequestJpaEntity(
                        registerBankAccount.getMembershipId(),
                        registerBankAccount.getBankName(),
                        registerBankAccount.getBankAccountNumber(),
                        registerBankAccount.isLinkedStatusIsValid()
                )
        );
    }
}
