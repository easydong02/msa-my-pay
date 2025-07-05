package com.mypay.membershipservice.adapter.out.persistence;

import com.mypay.membershipservice.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper  {

    public Membership mapToDomain(MembershipJpaEntity membershipJpaEntity) {
        return Membership.builder()
                .membershipId(membershipJpaEntity.getMembershipId())
                .name(membershipJpaEntity.getName())
                .email(membershipJpaEntity.getEmail())
                .address(membershipJpaEntity.getAddress())
                .isCorp(membershipJpaEntity.isCorp())
                .isValid(membershipJpaEntity.isValid())
                .build();
    }
}
