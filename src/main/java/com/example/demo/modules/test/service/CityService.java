package com.example.demo.modules.test.service;

import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.SearchVo;
import com.example.demo.modules.test.entity.City;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CityService {

    List<City> getCitiesByCountryId(Integer countryId);

    PageInfo<City> getCitiesBySearchVo(Integer countryId, SearchVo searchVo);

    public PageInfo<City> getCitiesBySearchVo(SearchVo searchVo);

    Result<City> insertCity(City city);

    Result<City> updateCity(City city);

    Result<Object> deleteCity(Integer cityId);
}
