package com.example.demo.modules.account.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: UserRoleDao
 * @Author ChenYang
 * @Date 2020/8/21   6:57 下午
 */

@Repository
@Mapper
public interface UserRoleDao {

    @Delete("delete from user_role where user_id = #{userId}")
    void delectUserRoleByUserId(Integer userId);

    @Insert("insert into user_role (user_id, role_id) " +
            "values (#{userId}, #{roleId})")
    void insertUserRole(Integer userId, Integer roleId);
}
