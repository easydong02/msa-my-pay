package com.mypay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterBankAccount {

    private final Long registerBankAccountId;

    private final Long membershipId;

    private final String bankName;

    private final String bankAccountNumber;

    private final boolean linkedStatusIsValid;
}
