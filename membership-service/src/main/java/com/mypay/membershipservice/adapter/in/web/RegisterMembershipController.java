package com.mypay.membershipservice.adapter.in.web;


import com.mypay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.mypay.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.mypay.membershipservice.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isCorp(request.isCorp())
                .isValid(true) // Assuming isValid is always true for this example
                .build();// Validate the command

        return registerMembershipUseCase.registerMembership(command);
    }
}
