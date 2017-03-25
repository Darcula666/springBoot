package com.gfdz.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/26.
 */
@Aspect
@Component
public class HttpAspect {
    @Before("execution(public * com.gfdz.controller.GirlController.*(..))")
    public void log(){
        System.out.println("11111111111111111111");
    }
}
