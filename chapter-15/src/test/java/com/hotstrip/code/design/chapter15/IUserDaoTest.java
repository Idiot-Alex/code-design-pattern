package com.hotstrip.code.design.chapter15;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

@Slf4j
public class IUserDaoTest {

    @Test
    public void testUserDao() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("100001");
        log.info("测试结果: {}", res);
    }
}