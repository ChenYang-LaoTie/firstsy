package com.example.demo.modules.account.service.impl;

import com.example.demo.modules.account.dao.UserDao;
import com.example.demo.modules.account.entity.User;
import com.example.demo.modules.account.service.UserService;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.example.demo.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

/**
 * @Description: UserServiceImpl
 * @Author ChenYang
 * @Date 2020/8/20   2:45 下午
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result<User> insertUser(User user) {
        User userTemp = userDao.getUserByUserName(user.getUserName());
        if (userTemp != null) {
            return new Result<User>(Result.ResultStatus.FAILD.status, "User name is repeat.");
        }

        user.setCreateDate(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        userDao.insertUser(user);
        return new Result<User>(Result.ResultStatus.SUCCESS.status, "Insert success.", user);
    }

    @Override
    public Result<User> login(User user) {
        User userTemp = userDao.getUserByUserName(user.getUserName());
        if (userTemp != null && userTemp.getPassword().equals(MD5Util.getMD5(user.getPassword()))) {
            return new Result<User>(Result.ResultStatus.SUCCESS.status, "success", userTemp);
        }
        return new Result<User>(Result.ResultStatus.FAILD.status,"UserName or password is error.");
    }

    @Override
    public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<User>(Optional.ofNullable(userDao.getUsersBySearchVo(searchVo)).orElse(Collections.emptyList()));
    }
}