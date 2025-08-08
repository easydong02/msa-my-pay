package com.mypay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmbankingRequest {

    private final Long firmbankingRequestId;

    private final String fromBankName;

    private final String fromBankAccountNumber;

    private final String toBankName;

    private final String toBankAccountNumber;

    private final int moneyAmount; // only won

    private final int firmbankingStatus; // 0: 요청, 1: 완료, 2: 실패

    private final java.util.UUID uuid;
}
