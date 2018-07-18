package com.lee.myrabbit.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 消费者实现Spring的MessageListener接口
 */
public class MessageConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("【*** 消息消费者 ***】" + message);
    }

}
