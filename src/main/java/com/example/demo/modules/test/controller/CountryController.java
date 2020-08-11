package com.example.demo.modules.test.controller;


import com.example.demo.modules.test.entity.Country;
import com.example.demo.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * 127.0.0.1/api/country/522 ---get
     */
    @GetMapping("/country/{countryId}")
    public Country getCountryByCountryId(@PathVariable Integer countryId) {
        return countryService.getCountryByCountryId(countryId);
    }


    /**
     * 127.0.0.1/api/country?countryName=China ---- get
     */
    @GetMapping("/country")
    public Country getCountryByCountryName(@RequestParam String countryName) {
        return countryService.getCountryByCountryName(countryName);
    }
}
