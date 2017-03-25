package com.gfdz.controller;

import com.gfdz.entity.GirlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/22.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    /*@Autowired
    private GirlEntity girl;


    @RequestMapping(value = {"/say", "/hi"}, method = RequestMethod.POST)
    *//*@RequestMapping(value = "/hello", method = RequestMethod.GET)*//*
    public String say(@RequestParam("id") Integer id) {
        return girl.getCupSize() + "," + girl.getAge() + "   " + id;

    }*/
}
