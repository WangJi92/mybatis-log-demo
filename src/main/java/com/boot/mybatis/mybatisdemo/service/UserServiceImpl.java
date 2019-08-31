package com.boot.mybatis.mybatisdemo.service;

import com.boot.mybatis.mybatisdemo.mapper.UserDoMapper;
import com.boot.mybatis.mybatisdemo.model.dataobject.UserDo;
import com.boot.mybatis.mybatisdemo.model.dataobject.UserDoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Override
    public UserDo findByUserName(String name) {
        UserDoExample example = new UserDoExample();
        example.createCriteria().andNameEqualTo(name);


        List<UserDo> userDos = userDoMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userDos)){
            return userDos.get(0);
        }
        return null;
    }

    @Override
    public List<UserDo> findAllUser() {
        UserDoExample example = new UserDoExample();
        example.createCriteria().andNameIsNotNull();
        return userDoMapper.selectByExample(example);
    }
}
