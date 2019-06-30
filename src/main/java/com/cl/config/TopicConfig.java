package com.cl.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
public class TopicConfig {
    @Value("${myTopicSB}")
    private String myTopicSB;
    //1.将topic注入springboot容器
    @Bean
    public Topic topic(){
        return new ActiveMQTopic(myTopicSB);
    }
}
