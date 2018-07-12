package com.lee.myrabbit.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class MessageProducer {
    private static final String EXCHANGE_NAME = "lee.msg.topic";    // 定义Exchange的名称
    private static final String HOST = "127.0.0.1"; // 消息服务的主机
    private static final Integer PORT = 5672; // 消息服务的端口号，注意一定要与管理界面的15672区分开。

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory(); // 建立一个连接工厂，所有的连接信息在此配置
        factory.setHost(HOST); // 设置消息的主机
        factory.setPort(PORT); // 设置连接端口
        factory.setUsername("yaya"); // 访问用户
        factory.setPassword("yaya"); // 连接密码
        factory.setVirtualHost("mydirect"); // 设置虚拟主机
        Connection connection = factory.newConnection(); // 定义一个新的RabbitMQ连接
        Channel channel = connection.createChannel(); // 创建一个通讯的通道
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");    // 定义EXCHANGE的声明
        long start = System.currentTimeMillis();
        for (int x = 0; x < 10; x++) {
            String msg = "Yayajava - " + x;
            if (x % 2 == 0) {
                channel.basicPublish(EXCHANGE_NAME, "yaya-key-1",
                        MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes()); // 进行消息发送
            } else {
                channel.basicPublish(EXCHANGE_NAME, "yaya-key-2",
                        MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes()); // 进行消息发送
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("本次操作所花费的时间：" + (end - start));
        channel.close();
        connection.close();
    }
}
