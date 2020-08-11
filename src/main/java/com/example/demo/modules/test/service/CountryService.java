package com.example.demo.modules.test.service;


import com.example.demo.modules.test.entity.Country;

public interface CountryService {
    Country getCountryByCountryId(int countryId);

    Country getCountryByCountryName(String countryName);

}
