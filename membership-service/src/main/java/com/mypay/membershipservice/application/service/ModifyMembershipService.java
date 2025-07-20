package com.mypay.membershipservice.application.service;

import com.mypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.mypay.membershipservice.application.port.in.ModifyMembershipCommand;
import com.mypay.membershipservice.application.port.in.ModifyMembershipUseCase;
import com.mypay.membershipservice.application.port.out.ModifyMembershipPort;
import com.mypay.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                Membership.builder()
                        .membershipId(command.getMembershipId())
                        .name(command.getName())
                        .email(command.getEmail())
                        .address(command.getAddress())
                        .isCorp(command.isCorp())
                        .isValid(command.isValid())
                        .build()
        );

        return membershipMapper.mapToDomain(jpaEntity);
    }
}
