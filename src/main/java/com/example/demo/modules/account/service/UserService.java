package com.example.demo.modules.account.service;

import com.example.demo.modules.account.entity.User;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: UserService
 * @Author ChenYang
 * @Date 2020/8/20   2:44 下午
 */
public interface UserService {

    Result<User> insertUser(User user);

    Result<User> login(User user);

    PageInfo<User> getUsersBySearchVo(SearchVo searchVo);

    Result<User> updateUser(User user);

    Result<Object> deleteUser(Integer userId);

    User getUserByUserId(Integer userId);

    Result<String> uploadUserImg(MultipartFile file);

    Result<User> updateUserProfile(User user);

    User getUserByUserName(String userName);

    void logout();
}
