package com.mypay.membershipservice.application.port.out;

import com.mypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membershipservice.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(Membership membership);
}
