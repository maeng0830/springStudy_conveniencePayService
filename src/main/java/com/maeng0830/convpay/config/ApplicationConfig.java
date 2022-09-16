package com.maeng0830.convpay.config;

import com.maeng0830.convpay.ConvpayApplication;
import com.maeng0830.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@ComponentScan(basePackages = "com.maeng0830.convpay")
// @ComponentScan(basePackageClasses = ConvpayApplication.class)
public class ApplicationConfig {

}
