package com.digi.banksystem.config;

import com.digi.banksystem.util.MD5Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new MD5Encoder();
    }
}