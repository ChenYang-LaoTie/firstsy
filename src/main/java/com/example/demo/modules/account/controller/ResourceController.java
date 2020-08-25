package com.example.demo.modules.account.controller;

import com.example.demo.modules.account.entity.Resource;
import com.example.demo.modules.account.service.ResourceService;
import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: ResourceDao
 * @Author ChenYang
 * @Date 2020/8/25   2:47 下午
 */

@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping(value = "/resources", consumes = "application/json")
    public PageInfo<Resource> getResources(@RequestBody SearchVo searchVo) {
        return resourceService.getResources(searchVo);
    }

    @PostMapping(value = "/resource", consumes = "application/json")
    public Result<Resource> insertResource(@RequestBody Resource resource) {
        return resourceService.editResource(resource);
    }

    @PutMapping(value = "/resource", consumes = "application/json")
    public Result<Resource> updateResource(@RequestBody Resource resource) {
        return resourceService.editResource(resource);
    }

    @RequestMapping("/resource/{resourceId}")
    public Resource getResourceById(@PathVariable int resourceId) {
        return resourceService.getResourceById(resourceId);
    }

    @DeleteMapping("/resource/{resourceId}")
    public Result<Resource> deleteResource(@PathVariable int resourceId) {
        return resourceService.deleteResource(resourceId);
    }

}
