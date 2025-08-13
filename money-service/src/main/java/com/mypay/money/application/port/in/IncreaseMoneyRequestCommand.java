package com.mypay.money.application.port.in;

import com.mypay.common.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {

    @NotNull
    private final Long targetMembershipId;

    @NotNull
    private final int amount;


    public IncreaseMoneyRequestCommand(Long targetMembershipId, int amount) {
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;

        this.validateSelf();
    }
}
