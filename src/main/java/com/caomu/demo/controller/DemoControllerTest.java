package com.caomu.demo.controller;


import org.junit.runner.RunWith;
import org.redisson.api.RMapCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.caomu.bootstrap.domain.BaseUserDetail;
import com.caomu.bootstrap.token.TokenUtil;
import com.caomu.demo.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoControllerTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(DemoControllerTest.class);
    @Autowired
    public RMapCache<Long, BaseUserDetail> authIdUserMap;
    @Autowired
    private TokenUtil<UserEntity> userEntityTokenUtil;
    @Autowired
    private IdentifierGenerator idGenerator;

    public void redis() {

    }

}