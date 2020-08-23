package com.example.demo.modules.account.controller;

import com.example.demo.modules.account.entity.Role;
import com.example.demo.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: RoleController
 * @Author ChenYang
 * @Date 2020/8/23   1:30 下午
 */

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 127.0.0.1/api/roles ---- get
     */
    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
