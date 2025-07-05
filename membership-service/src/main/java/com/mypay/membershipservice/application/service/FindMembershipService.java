package com.mypay.membershipservice.application.service;

import com.mypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.mypay.membershipservice.application.port.in.FindMembershipCommand;
import com.mypay.membershipservice.application.port.in.FindMembershipUseCase;
import com.mypay.membershipservice.application.port.out.FindMembershipPort;
import com.mypay.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity membershipJpaEntity = findMembershipPort.fineMembership(command.getMembershipId());

        return membershipMapper.mapToDomain(membershipJpaEntity);
    }
}
