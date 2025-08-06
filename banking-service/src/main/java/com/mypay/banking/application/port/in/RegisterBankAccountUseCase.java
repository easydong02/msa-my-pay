package com.mypay.banking.application.port.in;

import com.mypay.banking.domain.RegisterBankAccount;
import com.mypay.common.UseCase;

@UseCase
public interface RegisterBankAccountUseCase {

    RegisterBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
