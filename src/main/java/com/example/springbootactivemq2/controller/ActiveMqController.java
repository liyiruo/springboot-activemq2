package com.example.springbootactivemq2.controller;

import com.example.springbootactivemq2.pojo.User;
import com.example.springbootactivemq2.service.ActiveMqService;
import com.example.springbootactivemq2.service.ActiveMqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("activemq")
@Controller
public class ActiveMqController {

    @Autowired
    private ActiveMqService activeMqService;
    @Autowired
    private ActiveMqUserService activeMqUserService;


    @GetMapping("msg")
    @ResponseBody
    public Map<String, Object> msg(String message) {
        activeMqService.sendMsg(message);
        return result(true, message);
    }

    @GetMapping("user")
    @ResponseBody
    public Map<String, Object> msg(Long id, String name, String note) {
        User user = new User(id, name, note);
        activeMqUserService.sendUser(user);
        return result(true, user);
    }

    private Map<String, Object> result(Boolean success, Object message) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("message", message);
        return result;
    }

}

