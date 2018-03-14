package com.wqs.root.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqs.root.domain.User;
import com.wqs.root.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService implements Serializable {
    @Autowired
    private UserMapper userMapper;
    public Page<User> findUserPage(int pageNumber, int pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        return userMapper.findUserPage();
    }
}
