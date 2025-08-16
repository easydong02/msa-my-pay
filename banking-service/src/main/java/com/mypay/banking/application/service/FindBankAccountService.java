package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.mypay.banking.application.port.in.FindBankAccountCommand;
import com.mypay.banking.application.port.in.FindBankAccountUseCase;
import com.mypay.banking.application.port.out.FindBankAccountPort;
import com.mypay.banking.domain.FindBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FindBankAccountService implements FindBankAccountUseCase {

    private final FindBankAccountPort findBankAccountPort;

    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    @Override
    public List<FindBankAccount> findBankAccount(FindBankAccountCommand command) {
        List<RegisteredBankAccountJpaEntity> registerBankAccounts = findBankAccountPort.findRegisterBankAccount(command.getMembershipId());
        return registeredBankAccountMapper.mapToDomains(registerBankAccounts);
    }
}
