package com.mypay.money.adapter.in.web;


import com.mypay.common.WebAdapter;
import com.mypay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.mypay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.mypay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

    private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;

    @PostMapping("/money/increase")
    MoneyChangingResultDetail increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {

        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
                .targetMembershipId(request.getTargetMembershipId())
                .amount(request.getAmount())
                .build();

        // MoneyChangingRequest -> MoneyChangingResultDetail
        MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);
        return new MoneyChangingResultDetail(
                moneyChangingRequest.getMoneyChangingRequestId(),
                0,
                moneyChangingRequest.getChangingMoneyStatus(),
                moneyChangingRequest.getChangingMoneyAmount()
        );
    }


    @PostMapping("/money/decrease")
    MoneyChangingResultDetail decreaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {
    //
    //        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
    //                .membershipId(request.getMembershipId())
    //                .bankName(request.getBankName())
    //                .bankAccountNumber(request.getBankAccountNumber())
    //                .isValid(request.isValid())
    //                .build();

        // -> MoneyChangingResultDetail
        return null;
    }
}
