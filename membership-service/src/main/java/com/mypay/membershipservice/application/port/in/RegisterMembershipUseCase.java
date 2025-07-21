package com.mypay.membershipservice.application.port.in;

import com.mypay.common.UseCase;
import com.mypay.membershipservice.domain.Membership;

@UseCase
public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
