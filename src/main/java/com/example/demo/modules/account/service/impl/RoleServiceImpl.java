package com.example.demo.modules.account.service.impl;

import com.example.demo.modules.account.dao.RoleDao;
import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Description: RoleServiceImpl
 * @Author ChenYang
 * @Date 2020/8/23   2:02 下午
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getRoles() {
        return Optional.ofNullable(roleDao.getRoles()).orElse(Collections.emptyList());
    }
}
