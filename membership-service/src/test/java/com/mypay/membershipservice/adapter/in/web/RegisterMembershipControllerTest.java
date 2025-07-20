package com.mypay.membershipservice.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypay.membershipservice.domain.Membership;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerMembership() throws Exception {
        RegisterMembershipRequest request = new RegisterMembershipRequest(
                "John Doe", "easydong02@gmail.com", "123 Main St", false);

        Membership membership = Membership.builder().name("John Doe")
                .membershipId(1L)
                .email("easydong02@gmail.com")
                .address("123 Main St")
                .isValid(true)
                .isCorp(false).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/membership/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(membership)));
    }
}