package com.mypay.money.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "member_money")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberMoneyJpaEntity {

    @Id
    @GeneratedValue
    private Long memberMoneyId;

    private Long membershipId;

    private int balance;

    public MemberMoneyJpaEntity(Long membershipId, int balance) {
        this.membershipId = membershipId;
        this.balance = balance;
    }
}
