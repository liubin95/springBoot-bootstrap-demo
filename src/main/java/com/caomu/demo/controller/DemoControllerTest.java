package com.caomu.demo.controller;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.GeoUnit;
import org.redisson.api.RGeo;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.caomu.demo.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(DemoControllerTest.class);

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 基于redis的地理位置使用方法
     * 附近的人
     * 需要高版本redis
     */
    @Test
    public void redisGeo() {
        final RGeo<UserEntity> geo = redissonClient.getGeo("PARK::GEO");
        final UserEntity entity = new UserEntity();
        entity.setUserName("三丰大厦");
        geo.add(121.523394, 38.867643, entity);

        final UserEntity entity1 = new UserEntity();
        entity1.setUserName("第八区");
        geo.add(121.522855, 38.863937, entity1);

        final UserEntity entity2 = new UserEntity();
        entity2.setUserName("万达");
        geo.add(121.540179, 38.86827, entity2);

        final UserEntity entity3 = new UserEntity();
        entity3.setUserName("大连站");
        geo.add(121.639065, 38.928782, entity3);

        LOGGER.info("三丰到大连站：{}m ", geo.dist(entity, entity3, GeoUnit.METERS));
        LOGGER.info("三丰到大连站：{}km ", geo.dist(entity, entity3, GeoUnit.KILOMETERS));

        final List<UserEntity> radius = geo.radius(121.573955, 38.88473, 10, GeoUnit.KILOMETERS);
        LOGGER.info("星海公园半径10km，目标集合：{}个", radius.size());
        radius.forEach(item -> LOGGER.info(item.getUserName()));
        final List<UserEntity> radius1 = geo.radius(121.523394, 38.867643, 2, GeoUnit.KILOMETERS);
        LOGGER.info("三丰半径2km，目标集合：{}个", radius1.size());
        radius1.forEach(item -> LOGGER.info(item.getUserName()));

    }

}