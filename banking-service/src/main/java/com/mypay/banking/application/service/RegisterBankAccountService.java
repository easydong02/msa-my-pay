package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.BankAccount;
import com.mypay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.mypay.banking.application.port.in.RegisterBankAccountCommand;
import com.mypay.banking.application.port.in.RegisterBankAccountUseCase;
import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.domain.RegisterBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    @Override
    public RegisterBankAccount registerBankAccount(RegisterBankAccountCommand command) {
        BankAccount bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(
                new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber())
        );

        boolean isValid = bankAccountInfo.isValid();

        if (isValid) {
            RegisteredBankAccountJpaEntity jpaEntity = registerBankAccountPort.createRegisterBankAccount(
                    RegisterBankAccount.builder()
                            .membershipId(command.getMembershipId())
                            .bankName(command.getBankName())
                            .bankAccountNumber(command.getBankAccountNumber())
                            .linkedStatusIsValid(command.isValid())
                            .build()
            );

            return registeredBankAccountMapper.mapToDomain(jpaEntity);
        } else {
            return null;
        }
    }
}
