package com.example.springbootactivemq2.service;

public interface ActiveMqService {
//发送消息
    void sendMsg(String message);
//接收消息
    void receiveMsg(String message);

}
