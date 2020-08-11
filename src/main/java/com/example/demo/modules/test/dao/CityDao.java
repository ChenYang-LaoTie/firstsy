package com.example.demo.modules.test.dao;

import com.example.demo.modules.test.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description CityDao
 * @Author ChenYang
 * @Date 2020/8/11 19:07
 */

@Repository
@Mapper
public interface CityDao {

    @Select("select * from m_city where country_id = #{countryId}")
    List<City> getCitiesByCountryId(Integer countryId);
}
