package com.mypay.money.domain;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {

    private final Long moneyChangingRequestId;

    // 어떤 고객의 증/감액 요청을 했는지?
    private final Long targetMembershipId;

    // 그 요청이 증액인지 감액인지
    private final int moneyChangingType;  // 0: 증액, 1: 감액

    // 증/감액의 금액
    private final int changingMoneyAmount;

    // 머니 변액 요청에 대한상태
    private final int changingMoneyStatus; // 0: 성공, 1: 실패

    private final UUID uuid;

    private final Date createdAt;
}