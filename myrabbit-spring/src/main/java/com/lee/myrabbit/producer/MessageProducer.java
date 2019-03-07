package com.lee.myrabbit.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class MessageProducer {
    private static final String EXCHANGE_NAME = "lee.msg.topic";
    private static final String HOST = "127.0.0.1";
    // 消息服务的端口号，注意一定要与管理界面的15672区分开。
    private static final Integer PORT = 5672;

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setUsername("yaya");
        factory.setPassword("yaya");
        factory.setVirtualHost("mydirect");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        long start = System.currentTimeMillis();
        for (int x = 0; x < 10; x++) {
            String msg = "Yayajava - " + x;
            if (x % 2 == 0) {
                channel.basicPublish(EXCHANGE_NAME, "yaya-key-1",
                        MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
            } else {
                channel.basicPublish(EXCHANGE_NAME, "yaya-key-2",
                        MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("本次操作所花费的时间：" + (end - start));
        channel.close();
        connection.close();
    }
}
