package com.mypay.banking.adapter.out.external.bank;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmbankingResult {

    private int resultCode; // 0: 성공, 1: 실패
}
