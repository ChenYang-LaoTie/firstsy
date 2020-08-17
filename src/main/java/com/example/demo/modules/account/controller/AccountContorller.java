package com.example.demo.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: AccountContorller
 * @Author ChenYang
 * @Date 2020/8/17   4:57 下午
 */

@Controller
@RequestMapping("/account")
public class AccountContorller {
    /**
     * 127.0.0.1/account/users ---- get
     */
    @GetMapping("/users")
    public String usersPage() {
        return "index";
    }
}
