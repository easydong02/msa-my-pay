package com.mypay.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 실제 외부 은행의 계좌 정보
*
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String bankName;

    private String accountNumber;

    private boolean isValid;
}
