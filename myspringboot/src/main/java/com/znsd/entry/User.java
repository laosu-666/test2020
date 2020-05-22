package com.znsd.entry;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
public class User {

    public String status;
    @ApiModelProperty("用户名称")
    private String userName;
    private String password;


    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String status, String userName, String password) {
        this.status = status;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "status='" + status + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
