package com.mypay.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

    private Long moneyChangingRequestId;

    // 증액, 감액 판별
    private int moneyChangingType;

    private int moneyChangingResultStatus;

    private int amount;
}