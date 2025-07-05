package com.mypay.membershipservice.adapter.out.persistence;

import com.mypay.membershipservice.application.port.out.RegisterMembershipPort;
import com.mypay.membershipservice.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership membership) {
        return membershipRepository.save(
                new MembershipJpaEntity(
                membership.getName(),
                membership.getEmail(),
                membership.getAddress(),
                membership.isCorp(),
                membership.isValid()));
    }
}
