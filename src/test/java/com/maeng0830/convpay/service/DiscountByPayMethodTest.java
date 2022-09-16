package com.maeng0830.convpay.service;

import com.maeng0830.convpay.dto.PayRequest;
import com.maeng0830.convpay.type.ConvenienceType;
import com.maeng0830.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();
    @Test
    void discountTest_payMethod() {
        // given
        PayRequest payRequestMoney =
                new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequestCard =
                new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);

        // when
        Integer discountedAmountMoney =
                discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer discountedAmountCard =
                discountByPayMethod.getDiscountedAmount(payRequestCard);

        // then
        assertEquals(700, discountedAmountMoney);
        assertEquals(1000, discountedAmountCard);
    }

}