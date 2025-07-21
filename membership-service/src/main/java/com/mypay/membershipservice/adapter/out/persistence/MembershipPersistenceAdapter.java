package com.mypay.membershipservice.adapter.out.persistence;

import com.mypay.common.PersistenceAdapter;
import com.mypay.membershipservice.application.port.out.FindMembershipPort;
import com.mypay.membershipservice.application.port.out.ModifyMembershipPort;
import com.mypay.membershipservice.application.port.out.RegisterMembershipPort;
import com.mypay.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

    @Override
    public MembershipJpaEntity fineMembership(Long membershipId) {
        Optional<MembershipJpaEntity> membershipJpa = membershipRepository.findById(membershipId);
        return membershipJpa.orElse(null);
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership membership) {
        MembershipJpaEntity membershipJpa = membershipRepository.getById(membership.getMembershipId());

        membershipJpa.setName(membership.getName());
        membershipJpa.setEmail(membership.getEmail());
        membershipJpa.setAddress(membership.getAddress());
        membershipJpa.setCorp(membership.isCorp());
        membershipJpa.setValid(membership.isValid());
        return membershipRepository.save(membershipJpa);

    }
}
