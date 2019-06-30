package com.cl.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
public class Publisher {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    //每隔5s向队列中发送msg
    @Scheduled(fixedDelay = 5000)
    public void send(){
        String msg = System.currentTimeMillis()+"";
        jmsMessagingTemplate.convertAndSend(topic,msg);
        System.out.println("采用发布订阅通讯模式");
    }
}
