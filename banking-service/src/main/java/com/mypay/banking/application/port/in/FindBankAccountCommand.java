package com.mypay.banking.application.port.in;

import com.mypay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class FindBankAccountCommand extends SelfValidating<FindBankAccountCommand> {

    @NotNull
    private final Long membershipId;


    public FindBankAccountCommand(Long membershipId) {
        this.membershipId = membershipId;

        this.validateSelf();
    }
}
