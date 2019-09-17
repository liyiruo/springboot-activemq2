package com.example.springbootactivemq2.service;

import com.example.springbootactivemq2.pojo.User;

public interface ActiveMqUserService {
//发送消息
    void sendUser(User user);
//接收消息
    void receiveUser(User user);

}
