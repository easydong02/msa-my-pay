package com.mypay.membershipservice.application.port.in;

import com.mypay.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    private final String address;

    private final boolean isCorp;

    @AssertTrue
    private final boolean isValid;

    public RegisterMembershipCommand(String name, String email, String address, boolean isCorp, boolean isValid) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isCorp = isCorp;
        this.isValid = isValid;

        this.validateSelf();
    }
}
