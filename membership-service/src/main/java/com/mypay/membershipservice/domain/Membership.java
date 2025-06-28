package com.mypay.membershipservice.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    private final String membershipId;

    private final String name;

    private final String email;

    private final String address;

    private final boolean isValid;

    private final boolean isCorp;
}
