package com.boot.mybatis.mybatisdemo.service;

import com.boot.mybatis.mybatisdemo.model.dataobject.UserDo;

import java.util.List;

public interface UserService {


    UserDo findByUserName(String name);

    List<UserDo> findAllUser();
}
