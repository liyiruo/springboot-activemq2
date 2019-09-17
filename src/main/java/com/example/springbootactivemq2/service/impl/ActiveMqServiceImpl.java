package com.example.springbootactivemq2.service.impl;

import com.example.springbootactivemq2.service.ActiveMqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {
    private final static Logger logger = LoggerFactory.getLogger(ActiveMqServiceImpl.class);
    //    注入springboot自动生产的jmsTemplate
    @Autowired
    private JmsTemplate jmsTemplate = null;

    @Override
    public void sendMsg(String message) {
        logger.info("发送消息【{}】", message);
        jmsTemplate.convertAndSend(message);
//        自定义发送地址
//        jmsTemplate.convertAndSend("your-destination", message);
    }

    @Override
//    使用注解监听，监听地址发送过来的消息
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMsg(String message) {
        logger.info("接收到的消息【{}】", message);
    }
}
