package com.mypay.money.adapter.in.web;

import com.mypay.money.domain.MoneyChangingRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

    private Long moneyChangingRequestId;

    // 증액, 감액 판별
    private MoneyChangingType moneyChangingType;

    private MoneyChangingResultStatus moneyChangingResultStatus;

    private int amount;
}

enum MoneyChangingType{
    INCREASE,
    DECREASE
}


enum MoneyChangingResultStatus{
    SUCCEEDED,
    FAILED,
    FAILED_NOT_ENOUGH_AMOUNT,
    FAILED_NOT_EXIST_MEMBERSHIP,
}