package com.mypay.membershipservice.adapter.in.web;


import com.mypay.membershipservice.application.port.in.FindMembershipCommand;
import com.mypay.membershipservice.application.port.in.FindMembershipUseCase;
import com.mypay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.mypay.membershipservice.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMemberShipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable Long membershipId) {

        FindMembershipCommand command = FindMembershipCommand.builder().membershipId(membershipId).build();

        Membership membership = findMembershipUseCase.findMembership(command);

        return ResponseEntity.ok(membership);
    }
}
