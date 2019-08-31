package com.boot.mybatis.mybatisdemo.controller;

import com.boot.mybatis.mybatisdemo.model.dataobject.UserDo;
import com.boot.mybatis.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/findAll")
    @ResponseBody
    public List<UserDo> findAll(){
       return userService.findAllUser();
    }


    @GetMapping("/user/findAll/{name}")
    @ResponseBody
    public UserDo findByName(@PathVariable String name){
        return userService.findByUserName(name);
    }




}
