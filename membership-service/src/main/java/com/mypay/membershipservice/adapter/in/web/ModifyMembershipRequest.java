package com.mypay.membershipservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyMembershipRequest {

    private Long membershipId;

    private String name;

    private String email;

    private String address;

    private boolean isCorp;

    private boolean isValid;
}
