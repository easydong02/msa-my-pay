package com.mypay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {

    private final Long memberMoneyId;

    private final Long membershipId;

    private final int balance;

//    private final int linkedBankAccount;
}