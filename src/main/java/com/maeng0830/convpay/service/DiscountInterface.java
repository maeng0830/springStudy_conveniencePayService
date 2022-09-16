package com.maeng0830.convpay.service;

import com.maeng0830.convpay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}
