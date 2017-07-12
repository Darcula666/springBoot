package com.gfdz.controller;

import com.gfdz.entity.GirlEntity;
import com.gfdz.entity.ResultEntity;
import com.gfdz.repository.GirlRepository;
import com.gfdz.service.GirlService;
import com.gfdz.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.SocketTimeoutException;
import java.util.List;

/**
 * Created by Administrator on 2017/3/26.
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<GirlEntity> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param girl
     * @return
     * @Valid:验证
     */
    @PostMapping("/girls")
    public ResultEntity<GirlEntity> girlAdd(@Valid GirlEntity girl, BindingResult bindingResult) {
        ResultEntity result=new ResultEntity();
        if (bindingResult.hasErrors()) {//发生错误
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询一个女生
     *
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public GirlEntity girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新
     *
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public GirlEntity girlUpdate(@PathVariable("id") Integer id,
                                 @RequestParam("cupSize") String cupSize,
                                 @RequestParam("age") Integer age) {
        GirlEntity girl = new GirlEntity();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生列表
     *
     * @param age
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<GirlEntity> girlListByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }
    @GetMapping(value = "girls/getage/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
       girlService.getAge(id);
    }

}
