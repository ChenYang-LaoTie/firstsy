package com.example.demo.controller;

import com.example.demo.vo.Vv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("test")
@Controller
public class testController {

    @Autowired
    private Vv v;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello SpringBoot";
    }

    @Value("${server.port}")
    public Integer port;
    @Value("${name}")
    public String name;
    @Value("${age}")
    public Integer age;
    @Value("${desc}")
    public String desc;
    @Value("${random}")
    public String random;

    /**
     * 192.168.18.99:8088/test/config ---get
     * @return
     */

    @GetMapping("config")
    @ResponseBody
    public String configTest(){
        StringBuffer sb = new StringBuffer();
        sb.append(port).append("---").append(name).append("---").append(age).append("---").append(desc).append("---").append(random).append("<br/>");
        sb.append(v.getPort()).append(v.getName()).append(v.getAge()).append(v.getDesc()).append(v.getRandom());
        return sb.toString();
    }

    @GetMapping("testDesc")
    @ResponseBody
    public String testDesc() {
        return "This is test module desc.";
    }
}
