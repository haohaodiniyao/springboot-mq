package com.example.springboot.mq.producer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by yaokai on 2017/11/16.
 */
@Component
public class Consumer1 {
    @JmsListener(destination = "mytest.queue", containerFactory = "jmsListener")
    public void receiveQueue(final TextMessage text, Session session) throws JMSException{
        try{
            System.out.println("接收:"+text);
            int a = 1/0;
            text.acknowledge();
        }catch (Exception e){
            session.recover();
        }
    }
}
