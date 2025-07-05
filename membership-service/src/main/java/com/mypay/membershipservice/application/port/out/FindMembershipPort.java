package com.mypay.membershipservice.application.port.out;

import com.mypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;

public interface FindMembershipPort {

    MembershipJpaEntity fineMembership(Long membershipId);
}
