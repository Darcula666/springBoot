package com.gfdz.controller;

import com.gfdz.entity.GirlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/22.
 */
@RestController
public class HelloController {
   @Autowired
   private GirlEntity girl;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "index";

    }
}
