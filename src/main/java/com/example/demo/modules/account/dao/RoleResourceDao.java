package com.example.demo.modules.account.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: RoleResourceDao
 * @Author ChenYang
 * @Date 2020/8/25   2:02 下午
 */

@Repository
@Mapper
public interface RoleResourceDao {

    @Delete("delete from role_resource where resource_id = #{resourceId}")
    void deletRoleResourceByResourceId(int resourceId);

    @Insert("insert role_resource(role_id, resource_id) value(#{roleId}, #{resourceId})")
    void addRoleResource(@Param("roleId") int roleId, @Param("resourceId") int resourceId);
}
