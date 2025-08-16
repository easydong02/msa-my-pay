package com.mypay.money.adapter.out.persistence;

import com.mypay.common.PersistenceAdapter;
import com.mypay.money.application.port.out.IncreaseMoneyPort;
import com.mypay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;


@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

    private final SpringDataMemberMoneyRepository memberMoneyRepository;

    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingRequest(MoneyChangingRequest moneyChangingRequest) {
        return moneyChangingRequestRepository.save(new MoneyChangingRequestJpaEntity(
                moneyChangingRequest.getTargetMembershipId(),
                moneyChangingRequest.getMoneyChangingType(),
                moneyChangingRequest.getChangingMoneyAmount(),
                new Timestamp(System.currentTimeMillis()),
                moneyChangingRequest.getChangingMoneyStatus(),
                moneyChangingRequest.getUuid()
        ));
    }

    @Override
    public MemberMoneyJpaEntity increaseMoney(Long membershipId, int increaseMoneyAmount) {
        MemberMoneyJpaEntity memberMoneyJpaEntity = memberMoneyRepository.findByMembershipId(membershipId)
                .orElse(null);

        if (memberMoneyJpaEntity == null) {
            memberMoneyJpaEntity = new MemberMoneyJpaEntity(membershipId, increaseMoneyAmount);
            return memberMoneyRepository.save(memberMoneyJpaEntity);
        }

        memberMoneyJpaEntity.setBalance(memberMoneyJpaEntity.getBalance() + increaseMoneyAmount);
        return memberMoneyRepository.save(memberMoneyJpaEntity);
    }
}
