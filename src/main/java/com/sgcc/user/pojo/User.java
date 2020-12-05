package com.sgcc.user.pojo;

import lombok.Data;

@Data
public class User {
    private String id;

    private String userName;

    private String password;

    private Integer age;


    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age + "]";
    }    
}