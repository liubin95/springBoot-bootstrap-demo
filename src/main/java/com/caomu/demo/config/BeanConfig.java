package com.caomu.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caomu.bootstrap.token.TokenUtil;
import com.caomu.demo.entity.UserEntity;

/**
 * 配置对象
 *
 * @author admin
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

}
