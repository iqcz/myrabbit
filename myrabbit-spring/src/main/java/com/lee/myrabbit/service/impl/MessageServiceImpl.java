package com.lee.myrabbit.service.impl;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.lee.myrabbit.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
    @Resource(name = "amqpTemplate")
    private AmqpTemplate amqpTemplate;

    @Override
    public void send(String message) {
        this.amqpTemplate.convertAndSend("lee-key", message);
    }

}
