package com.example.demo.modules.account.service.impl;

import com.example.demo.modules.account.dao.RoleDao;
import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.account.service.RoleService;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public Result<Role> editRole(Role role) {
        Role roleTemp = roleDao.getRoleByRoleName(role.getRoleName());
        if (roleTemp != null && roleTemp.getRoleId() != role.getRoleId()) {
            return new Result<Role>(Result.ResultStatus.FAILD.status, "Role name is repeat.");
        }
        if (null != role.getRoleId()) {
            roleDao.updateRole(role);
        } else {
            roleDao.addRole(role);
        }
        return new Result<Role>(Result.ResultStatus.SUCCESS.status, "success", role);
    }

    @Override
    @Transactional
    public Result<Role> deleteRole(Integer roleId) {
        roleDao.deleteRole(roleId);
        return new Result<Role>(Result.ResultStatus.SUCCESS.status, "success");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public PageInfo<Role> getRoles(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<>(Optional.ofNullable(roleDao.getRolesBySearchVo(searchVo)).orElse(Collections.emptyList()));
    }

    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return roleDao.getRolesByUserId(userId);
    }

    @Override
    public List<Role> getRolesByResourceId(Integer resourceId) {
        return roleDao.getRolesByResourceId(resourceId);
    }

    @Override
    public Role getRoleById(Integer roleId) {
        return roleDao.getRoleById(roleId);
    }
}
