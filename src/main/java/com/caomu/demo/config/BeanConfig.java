package com.caomu.demo.config;

import com.caomu.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 配置对象
 *
 * @author 刘斌
 */
@Configuration
public class BeanConfig {

    /**
     * 装配实现UserDetailsService 的实现类
     *
     * @param service 用户实现类
     * @return 实现类
     */
    @Bean
    @Autowired
    public UserDetailsService userDetailsService(UserServiceImpl service) {
        return service;
    }

}
