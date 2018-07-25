package com.xwtech.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class FreeeMarkerController {

    @RequestMapping(value = "/testFtl",method =GET, produces = "application/json")
    public String testFtl(Model model){
        Map<String,Object> map =  new HashMap<>();
        map.put("name","jack");
        map.put("age",18);
        map.put("sec","女");
        model.addAttribute("map",map);
        return "test";
    }
}
