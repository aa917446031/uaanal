package com.ucloud.uaanal.controller;


import com.ucloud.uaanal.entity.SysTest;
import com.ucloud.uaanal.service.SysTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
    private String prefix = "web";

    @Autowired
    SysTestService sysTestService;


    @GetMapping("/list")
    public String list(){
        SysTest sysTest = sysTestService.findId(1l);
        return "/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("id", 11);
        return prefix + "/test";
    }

    @GetMapping("/echarts")
    public String echarts(){
        return prefix + "/echarts";
    }
}
