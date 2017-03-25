package com.gfdz.service;

import com.gfdz.Exception.GirlException;
import com.gfdz.entity.GirlEntity;
import com.gfdz.enums.ResultEnum;
import com.gfdz.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/26.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception {
        GirlEntity girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回“你还在上小学吧” code:100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //你可能已经上初中了 code:101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生信息
     */
    public GirlEntity findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
