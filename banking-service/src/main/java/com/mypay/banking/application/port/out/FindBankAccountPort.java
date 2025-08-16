package com.mypay.banking.application.port.out;


import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;

import java.util.List;

public interface FindBankAccountPort {

    List<RegisteredBankAccountJpaEntity> findRegisterBankAccount(Long membershipId);
}
