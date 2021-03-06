package com.example.demo.modules.account.entity;

import javax.persistence.*;

/**
 * @Description: RoleResource
 * @Author ChenYang
 * @Date 2020/8/20   1:34 下午
 */

@Entity
@Table(name = "role_resource")
public class RoleResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleResourceId;
    private Integer roleId;
    private Integer resourceId;

    public Integer getRoleResourceId() {
        return roleResourceId;
    }

    public void setRoleResourceId(Integer roleResourceId) {
        this.roleResourceId = roleResourceId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
