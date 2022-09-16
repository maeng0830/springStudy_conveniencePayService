package com.maeng0830.convpay;

import com.maeng0830.convpay.config.ApplicationConfig;
import com.maeng0830.convpay.dto.PayCancelRequest;
import com.maeng0830.convpay.dto.PayCancelResponse;
import com.maeng0830.convpay.dto.PayRequest;
import com.maeng0830.convpay.dto.PayResponse;
import com.maeng0830.convpay.service.ConveniencePayService;
import com.maeng0830.convpay.type.ConvenienceType;
import com.maeng0830.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // '사용자' -> 편결이 -> 머니
        // applicationcontext는 Bean이라는 레고들을 끼울 수 있는 큰 레고판(컨테이너)
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService =
                applicationContext.getBean("conveniencePayService", ConveniencePayService.class);


        // G25, 결제 1000원
        PayRequest payRequest =
                new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // 취소 500원
        PayCancelRequest payCancelRequest =
                new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}
