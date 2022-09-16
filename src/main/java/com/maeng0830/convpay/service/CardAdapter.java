package com.maeng0830.convpay.service;

import com.maeng0830.convpay.type.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CardAdapter implements PaymentInterface {
    // 인증
    public void authorization() {
        System.out.println("authorization success.");
    }

    // 승인
    public void approval() {
        System.out.println("approval success.");
    }

    // 매입
    public CardUseResult capture(Integer payAmount) {
        if (payAmount > 100) {
            // 실패
            return CardUseResult.USE_FAIL;
        }

        // 성공

        return CardUseResult.USE_SUCCESS;
    }

    // 매입 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount) {
        if (cancelAmount < 1000) {
            // 실패
            return CardUseCancelResult.USE_CANCEL_FAIL;
        }

        // 성공
        return CardUseCancelResult.USE_CANCEL_SUCCESS;
    }

    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.CARD;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        capture(payAmount);
        CardUseResult cardUseResult = capture(payAmount);

        if (cardUseResult == CardUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        CardUseCancelResult cardUseCancelResult = cancelCapture(cancelAmount);

        if (cardUseCancelResult == CardUseCancelResult.USE_CANCEL_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }

        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
