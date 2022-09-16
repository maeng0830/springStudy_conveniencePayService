package com.maeng0830.convpay.service;

import com.maeng0830.convpay.dto.PayRequest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// @Profile("test")
public class DiscountByConvenience implements DiscountInterface {
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        System.out.println("DiscountByConvenience called");
        switch (payRequest.getConvenienceType()) {
            case G25:
                return payRequest.getPayAmount() * 8 / 10;
            case GU:
                return payRequest.getPayAmount() * 9 / 10;
            case SEVEN:
                return payRequest.getPayAmount();
        }

        // 현재 상황에서 도달하지는 않겠지만, 리턴이 있어야 컴파일 에러 X
        return payRequest.getPayAmount();
    }
}
