package com.example.demo.modules.test.service;

import com.example.demo.modules.common.vo.SearchVo;
import com.example.demo.modules.test.entity.City;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CityService {

    List<City> getCitiesByCountryId(Integer countryId);

    PageInfo<City> getCitiesBySearchVo(Integer countryId, SearchVo searchVo);
}
