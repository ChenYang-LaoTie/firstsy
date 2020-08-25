package com.example.demo.modules.account.service;

import com.example.demo.modules.account.entity.Resource;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ResourceService {

    Result<Resource> editResource(Resource resource);

    Result<Resource> deleteResource(Integer resourceId);

    PageInfo<Resource> getResources(SearchVo searchVo);

    List<Resource> getResourcesByRoleId(Integer roleId);

    Resource getResourceById(Integer resourceId);
}
