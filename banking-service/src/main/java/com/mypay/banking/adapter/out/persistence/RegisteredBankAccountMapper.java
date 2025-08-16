package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.domain.FindBankAccount;
import com.mypay.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisteredBankAccountMapper {

    public RegisterBankAccount mapToDomain(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {
        return RegisterBankAccount.builder()
                .registerBankAccountId(registeredBankAccountJpaEntity.getRegisterBankAccountId())
                .membershipId(registeredBankAccountJpaEntity.getMembershipId())
                .bankName(registeredBankAccountJpaEntity.getBankName())
                .bankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber())
                .linkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
                .build();
    }

    public List<FindBankAccount> mapToDomains(List<RegisteredBankAccountJpaEntity> registeredBankAccountJpaEntities) {
        List<FindBankAccount> result = new ArrayList<>();
        for (RegisteredBankAccountJpaEntity entity : registeredBankAccountJpaEntities) {
            FindBankAccount findBankAccount = FindBankAccount.builder()
                    .registerBankAccountId(entity.getRegisterBankAccountId())
                    .membershipId(entity.getMembershipId())
                    .bankName(entity.getBankName())
                    .bankAccountNumber(entity.getBankAccountNumber())
                    .linkedStatusIsValid(entity.isLinkedStatusIsValid())
                    .build();
            result.add(findBankAccount);
        }

        return result;
    }
}
