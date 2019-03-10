package com.lee.myrabbit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.myrabbit.service.IMessageService;

@ContextConfiguration(locations = {"classpath:spring/spring-producer.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestProducer {
    @Resource
    private IMessageService messageService;

    @Test
    public void testSend() {
        this.messageService.send("[*** 消息生产者 ***] - " + System.currentTimeMillis());
    }
}