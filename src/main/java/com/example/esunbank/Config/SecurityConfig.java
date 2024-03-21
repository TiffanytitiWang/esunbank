package com.example.esunbank.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)  //禁止CSRF（跨站請求偽造）保護。
                .authorizeHttpRequests((authorize) -> authorize //對所有訪問HTTP端點的HttpServletRequest進行限制
                        .requestMatchers(
                                "/product",
                                "/about",
                                "/home",
                                "/css/**",
                                "/javascript/**",
                                "/api/product",
                                "/image/**",
                                "/contact",
                                "/"
                        ).permitAll()   //指定上述匹配規則中的路徑，允許所有用戶訪問，即不需要進行身份驗證。
                        .anyRequest().authenticated()   //其他尚未匹配到的路徑都需要身份驗證
                );
        return http.build();
    }
}