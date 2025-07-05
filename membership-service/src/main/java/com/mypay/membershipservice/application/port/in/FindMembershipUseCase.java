package com.mypay.membershipservice.application.port.in;

import com.mypay.membershipservice.domain.Membership;
import common.UseCase;

@UseCase
public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
}
