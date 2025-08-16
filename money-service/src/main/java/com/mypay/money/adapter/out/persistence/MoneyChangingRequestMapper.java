package com.mypay.money.adapter.out.persistence;

import com.mypay.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {

    public MoneyChangingRequest mapToDomain(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity) {
        return MoneyChangingRequest.builder()
                .moneyChangingRequestId(moneyChangingRequestJpaEntity.getMoneyChangingRequestId())
                .targetMembershipId(moneyChangingRequestJpaEntity.getTargetMembershipId())
                .moneyChangingType(moneyChangingRequestJpaEntity.getMoneyChangingType())
                .changingMoneyAmount(moneyChangingRequestJpaEntity.getChangingMoneyAmount())
                .changingMoneyStatus(moneyChangingRequestJpaEntity.getChangingMoneyStatus())
                .uuid(moneyChangingRequestJpaEntity.getUuid())
                .build();
    }
}
