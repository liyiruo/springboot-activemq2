package com.example.springbootactivemq2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String note;
}
