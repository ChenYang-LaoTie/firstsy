package com.example.demo.modules.account.dao;

import com.example.demo.modules.account.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: RoleDao
 * @Author ChenYang
 * @Date 2020/8/21   7:17 下午
 */

@Repository
@Mapper
public interface RoleDao {

    @Select("select * from role r left join user_role ur on r.role_id = ur.role_id where ur.user_id = #{userId}")
    List<Role> getRolesByUserId(Integer userId);

    @Select("select * from role")
    List<Role> getRoles();
}
