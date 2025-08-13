package com.mypay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {

    private final Long moneyChangingRequestId;

    // 어떤 고객의 증/감액 요청을 했는지?
    private final Long targetMembershipId;

    // 그 요청이 증액인지 감액인지
    private final ChangingType changingType;

    enum ChangingType {
        INCREASE,
        DECREASE
    }

    // 증/감액의 금액
    private final int changingMoneyAmount;

    // 머니 변액 요청에 대한상태
    private final ChangingMoneyStatus changingMoneyStatus;

    enum ChangingMoneyStatus{
        REQUESTED,
        SUCCEEDED,
        FAILED,
        CANCELLED
    }

    private final String uuid;

    private final Date createdAt;
}