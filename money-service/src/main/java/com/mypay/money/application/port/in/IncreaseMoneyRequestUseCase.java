package com.mypay.money.application.port.in;

import com.mypay.common.UseCase;
import com.mypay.money.domain.MoneyChangingRequest;

@UseCase
public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
}
