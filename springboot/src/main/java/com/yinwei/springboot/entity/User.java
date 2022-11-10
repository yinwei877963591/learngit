package com.yinwei.springboot.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    @JsonIgnore//忽略某个变量，在前端不展示
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
}
