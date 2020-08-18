package com.example.demo.modules.test.controller;

import com.example.demo.modules.test.entity.City;
import com.example.demo.modules.test.entity.Country;
import com.example.demo.modules.test.service.CityService;
import com.example.demo.modules.test.service.CountryService;
import com.example.demo.modules.test.vo.Vv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("test")
@Controller
public class TestController {

    @Autowired
    private Vv v;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryServcie;


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
     * 127.0.0.1/test/file ---- get
     */
    @GetMapping("/file")
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName) {
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get("/Users/chenyang/" + fileName).toUri());
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/octet-stream").header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=\"%S\"", resource.getFilename())).body(resource);
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 127.0.0.1/test/files ---post
     */
    @PostMapping(value = "/files", consumes = "multipart/form-data")
    public String uploadFiles(@RequestParam MultipartFile[] files, RedirectAttributes redirectAttributes) {
        Boolean empty = true;
        try {
            for (MultipartFile file:files) {
                if (file.isEmpty()) {
                    continue;
                }

                String destFilePath = "/Users/chenyang/" + file.getOriginalFilename();
                System.out.println(destFilePath);
                File destFile = new File(destFilePath);
                file.transferTo(destFile);
                empty = false;

                if (empty) {
                    redirectAttributes.addFlashAttribute("message", "Please select file.");
                } else {
                    redirectAttributes.addFlashAttribute("message", "Upload file success");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Upload file failed.");
        }
        return "redirect:/test/index";
    }

    /**
     * 127.0.0.1/test/file ---- post
     */
    @PostMapping(value = "/file", consumes = "multipart/form-data")
    public String uploadFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select file.");
            return "redirect:/test/index";
        }

        try {
            String destFilePath = "/Users/chenyang/" + file.getOriginalFilename();
            File destFile = new File(destFilePath);
            System.out.println(destFilePath);
            file.transferTo(destFile);
            redirectAttributes.addFlashAttribute("message", "Upload file success.");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Upload file failed.");
        }

        return "redirect:/test/index";
    }


    /**
     * 127.0.0.1/test/index
     */
    @GetMapping("/index")
    public String testIndexPage(ModelMap modelMap) {
        int countryId = 522;
        List<City> cities = cityService.getCitiesByCountryId(countryId);
        cities = cities.stream().limit(10).collect(Collectors.toList());
        Country country = countryServcie.getCountryByCountryId(countryId);

        modelMap.addAttribute("thymeleafTitle", "scdscsadcsacd");
        modelMap.addAttribute("checked", true);
        modelMap.addAttribute("currentNumber", 99);
        modelMap.addAttribute("changeType", "checkbox");
        modelMap.addAttribute("baiduUrl", "/test/log");
        modelMap.addAttribute("city", cities.get(0));
        modelMap.addAttribute("shopLogo",
                "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
        modelMap.addAttribute("shopLogo",
                "/upload/1111.png");
        modelMap.addAttribute("country", country);
        modelMap.addAttribute("cities", cities);
        modelMap.addAttribute("updateCityUri", "/api/city");
//        modelMap.addAttribute("template", "test/index");
        // 返回外层的碎片组装器
        return "index";
    }

    /**
     * 127.0.0.1/test/index2
     */
    @GetMapping("/index2")
    public String testIndex2Page(ModelMap modelMap) {
        return "index";
    }

    /**
     * 192.168.18.99:443/test/config ---get
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

    /**
     * https://192.168.18.99:443/test/testDesc?paramKey=fuck ---get
     * @return
     */
    @GetMapping("testDesc")
    @ResponseBody
    public String testDesc(HttpServletRequest request, String paramKey, @RequestParam(value = "paramKey") String paramValue) {
        String paramValue2 =  request.getParameter("paramKey");

        return "This is test module desc." + "我" + paramValue2 + "你个" + paramKey + "TMD" + paramValue;
    }


}
