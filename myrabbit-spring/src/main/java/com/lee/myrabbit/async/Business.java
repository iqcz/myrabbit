package com.lee.myrabbit.async;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 业务处理
 * @author i324779
 */
public class Business {

    /**
     * 用户注册
     */
    public void userRegister() {
        //校验用户填写的信息是否完整

        //将用户及相关信息保存到数据库

        //注册成功后发送一条消息表示要发送邮件
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring/spring-consumer.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        Mail mail = new Mail();
        mail.setTo("XXX@gmail.com");
        mail.setSubject("邮件标题");
        mail.setContent("邮件内容");

        template.convertAndSend(mail);
        ctx.close();
    }

    public static void main(final String... args) {
        Business business = new Business();
        business.userRegister();
    }
}
