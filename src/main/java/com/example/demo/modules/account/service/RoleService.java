package com.example.demo.modules.account.service;

import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    Result<Role> editRole(Role role);

    Result<Role> deleteRole(Integer roleId);

    PageInfo<Role> getRoles(SearchVo searchVo);

    List<Role> getRolesByUserId(Integer userId);

    List<Role> getRolesByResourceId(Integer resourceId);

    Role getRoleById(Integer roleId);
}
