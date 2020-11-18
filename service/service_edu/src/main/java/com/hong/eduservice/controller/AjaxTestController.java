package com.hong.eduservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("teacher")
public class AjaxTestController {
    @GetMapping("/login/{name}")
    public Object login(@PathVariable String name){
        System.out.println(name);
        return "success";
    }
    @GetMapping("/list")
    public Object list(){
        String name="suibian";
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        return map;
    }
}
