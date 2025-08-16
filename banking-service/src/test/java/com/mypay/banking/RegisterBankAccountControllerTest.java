package com.mypay.banking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypay.banking.adapter.in.web.RegisterBankAccountRequest;
import com.mypay.banking.domain.RegisterBankAccount;
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
class RegisterBankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerBankAccount() throws Exception {
        RegisterBankAccountRequest request = new RegisterBankAccountRequest(
                1L, "my-bank", "1004-854-442901", true);

         RegisterBankAccount registerBankAccount = RegisterBankAccount.builder()
                 .registerBankAccountId(1L)
                .membershipId(1L)
                .bankName("my-bank")
                .bankAccountNumber("1004-854-442901")
                .linkedStatusIsValid(true)
                 .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/banking/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(registerBankAccount)));
    }
}