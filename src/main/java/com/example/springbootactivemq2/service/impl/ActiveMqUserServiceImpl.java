package com.example.springbootactivemq2.service.impl;

import com.example.springbootactivemq2.pojo.User;
import com.example.springbootactivemq2.service.ActiveMqService;
import com.example.springbootactivemq2.service.ActiveMqUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMqUserServiceImpl implements ActiveMqUserService {
    private final static Logger logger = LoggerFactory.getLogger(ActiveMqUserServiceImpl.class);
    private static final String myDestination = "my-destination";

    //    注入springboot自动生产的jmsTemplate
    @Autowired
    private JmsTemplate jmsTemplate = null;

    @Override
    public void sendUser(User user) {
        logger.info("发送消息【{}】", user);
        jmsTemplate.convertAndSend(myDestination, user);
//        自定义发送地址
//        jmsTemplate.convertAndSend("your-destination", message);
    }

    @Override
//    使用注解监听，监听地址发送过来的消息
    @JmsListener(destination = myDestination)
    public void receiveUser(User user) {
        logger.info("接收到的消息【{}】", user);
    }
}
