package com.mypay.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRegisteredBankAccountRepository extends JpaRepository<MoneyChangingRequestJpaEntity, Long> {
}
