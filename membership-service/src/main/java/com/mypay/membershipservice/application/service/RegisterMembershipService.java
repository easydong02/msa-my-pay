package com.mypay.membershipservice.application.service;

import com.mypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.mypay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.mypay.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.mypay.membershipservice.application.port.out.RegisterMembershipPort;
import com.mypay.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                Membership.builder()
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
