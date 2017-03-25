package com.gfdz.handle;

import com.gfdz.Exception.GirlException;
import com.gfdz.aspect.HttpAspect;
import com.gfdz.entity.ResultEntity;
import com.gfdz.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/3/26.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity handle(Exception e) {
        if(e instanceof GirlException){
            GirlException girlException= (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("【系统异常】"+e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
