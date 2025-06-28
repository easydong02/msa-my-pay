package com.mypay.membershipservice.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    @GetMapping("/test")
    void test() {
        System.out.println("Test endpoint hit");
    }
}
