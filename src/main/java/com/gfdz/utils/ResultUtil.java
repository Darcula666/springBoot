package com.gfdz.utils;

import com.gfdz.entity.ResultEntity;

/**
 * Created by Administrator on 2017/3/26.
 */
public class ResultUtil {
    public static ResultEntity success(Object object){
        ResultEntity result=new ResultEntity();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static ResultEntity success(){

        return success(null);
    }
    public static ResultEntity error(Integer code,String msg){
        ResultEntity result=new ResultEntity();
        result.setCode(1);
        result.setMsg(msg);
        result.setData(code);
        return result;
    }
}
