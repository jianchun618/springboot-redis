package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;
public interface UserMapper {
    List<User> queryAll();
    void save(User user);
}
