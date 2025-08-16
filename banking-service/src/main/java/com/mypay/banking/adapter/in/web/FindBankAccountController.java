package com.mypay.banking.adapter.in.web;


import com.mypay.banking.application.port.in.FindBankAccountCommand;
import com.mypay.banking.application.port.in.FindBankAccountUseCase;
import com.mypay.banking.domain.FindBankAccount;
import com.mypay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindBankAccountController {

    private final FindBankAccountUseCase findBankAccountUseCase;

    @GetMapping("/banking/account/find/{membershipId}")
    List<FindBankAccount> findBankAccount(@PathVariable Long membershipId) {

        FindBankAccountCommand command = FindBankAccountCommand.builder()
                .membershipId(membershipId)
                .build();

        List<FindBankAccount> bankAccounts = findBankAccountUseCase.findBankAccount(command);
        if (bankAccounts == null) {
            // TODO: Error Handling
            return null;
        }

        return bankAccounts;
    }
}
