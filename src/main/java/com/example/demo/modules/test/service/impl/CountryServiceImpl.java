package com.example.demo.modules.test.service.impl;

import com.example.demo.modules.test.dao.CountryDao;
import com.example.demo.modules.test.entity.Country;
import com.example.demo.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description CountryService
 * @Author ChenYang
 * @Date 2020 8/11 19:33
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;
    @Override
    public Country getCountryByCountryId(int countryId) {
        return countryDao.getCountryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return countryDao.getCountryByCountryName(countryName);
    }
}
