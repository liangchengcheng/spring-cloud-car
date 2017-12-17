package com.hdsx.car.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String avatar;
    private List mks;
    private String name ;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public List getMks() {
        return mks;
    }
    public void setMks(List mks) {
        this.mks = mks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
