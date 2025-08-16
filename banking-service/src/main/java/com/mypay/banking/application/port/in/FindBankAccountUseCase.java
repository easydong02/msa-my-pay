package com.mypay.banking.application.port.in;

import com.mypay.banking.domain.FindBankAccount;
import com.mypay.common.UseCase;

import java.util.List;

@UseCase
public interface FindBankAccountUseCase {

    List<FindBankAccount> findBankAccount(FindBankAccountCommand command);
}
