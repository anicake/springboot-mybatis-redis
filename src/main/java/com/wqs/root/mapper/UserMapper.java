package com.wqs.root.mapper;

import com.github.pagehelper.Page;
import com.wqs.root.domain.User;

import java.util.List;

public interface UserMapper {
    Page<User> findUserPage();
}
