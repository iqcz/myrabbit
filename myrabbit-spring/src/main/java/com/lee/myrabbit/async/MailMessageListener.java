package com.lee.myrabbit.async;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author i324779
 */
public class MailMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String body = new String(message.getBody());
        ObjectMapper mapper = new ObjectMapper();
        try {
            Mail mail = mapper.readValue(body, Mail.class);
            System.out.println("接收到邮件消息：" + mail);

            sendEmail(mail);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendEmail(Mail mail) {
        //调用 JavaMail API 发送邮件
        System.out.println("调用 JavaMail API 发送邮件.");
    }
}
