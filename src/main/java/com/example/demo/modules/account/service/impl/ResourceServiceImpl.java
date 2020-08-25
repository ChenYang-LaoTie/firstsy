package com.example.demo.modules.account.service.impl;

import com.example.demo.modules.account.dao.ResourceDao;
import com.example.demo.modules.account.dao.RoleResourceDao;
import com.example.demo.modules.account.entity.Resource;
import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.account.service.ResourceService;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Description: ResourceServiceImpl
 * @Author ChenYang
 * @Date 2020/8/25   2:06 下午
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private RoleResourceDao roleResourceDao;

    @Override
    public Result<Resource> editResource(Resource resource) {
        Resource resourceTemp = resourceDao.getResourceByPermission(resource.getPermission());
        if (resourceTemp != null && resourceTemp.getResourceId() != resource.getResourceId()) {
            return new Result<Resource>(Result.ResultStatus.FAILD.status, "Resource permission is repeat.");
        }

        // 添加 resource
        if (null != resource.getResourceId()) {
            resourceDao.updateResource(resource);
        } else {
            resourceDao.addResource(resource);
        }

        // 添加 roleResource
        roleResourceDao.deletRoleResourceByResourceId(resource.getResourceId());
        if (resource.getRoles() != null && !resource.getRoles().isEmpty()) {
            for (Role role : resource.getRoles()) {
                roleResourceDao.addRoleResource(role.getRoleId(), resource.getResourceId());
            }
        }
        return new Result<Resource>(Result.ResultStatus.SUCCESS.status, "success", resource);
    }

    @Override
    public Result<Resource> deleteResource(Integer resourceId) {
        roleResourceDao.deletRoleResourceByResourceId(resourceId);
        resourceDao.deleteResource(resourceId);
        return new Result<Resource>(Result.ResultStatus.SUCCESS.status, "success");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public PageInfo<Resource> getResources(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<>(Optional.ofNullable(resourceDao.getResourcesBySearchVo(searchVo)).orElse(Collections.emptyList()));
    }

    @Override
    public List<Resource> getResourcesByRoleId(Integer roleId) {
        return resourceDao.getResourcesByRoleId(roleId);
    }

    @Override
    public Resource getResourceById(Integer resourceId) {
        return resourceDao.getResourceById(resourceId);
    }
}
