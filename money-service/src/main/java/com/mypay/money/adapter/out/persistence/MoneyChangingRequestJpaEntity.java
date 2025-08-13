package com.mypay.money.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "money_changing_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingRequestJpaEntity {

    @Id
    @GeneratedValue
    private Long moneyChangingRequestId;

    private Long targetMembershipId;

    private int moneyChangingType;

    private int changingMoneyAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    private String changingMoneyStatus;

    public MoneyChangingRequestJpaEntity(Long targetMembershipId, int moneyChangingType, int changingMoneyAmount, Timestamp timestamp, String changingMoneyStatus) {
        this.targetMembershipId = targetMembershipId;
        this.moneyChangingType = moneyChangingType;
        this.changingMoneyAmount = changingMoneyAmount;
        this.timestamp = timestamp;
        this.changingMoneyStatus = changingMoneyStatus;
    }
}
