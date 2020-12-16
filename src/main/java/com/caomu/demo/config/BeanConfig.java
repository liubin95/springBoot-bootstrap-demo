package com.caomu.demo.config;

import com.caomu.bootstrap.token.TokenUtil;
import com.caomu.demo.entity.UserEntity;
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
     * 生成token工具类
     *
     * @return token工具类
     */
    @Bean
    public TokenUtil<UserEntity> userEntityTokenUtil() {

        return new TokenUtil<>(UserEntity.class);
    }

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
