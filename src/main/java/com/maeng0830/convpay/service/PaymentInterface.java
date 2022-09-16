package com.maeng0830.convpay.service;

import com.maeng0830.convpay.type.CancelPaymentResult;
import com.maeng0830.convpay.type.PayMethodType;
import com.maeng0830.convpay.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
