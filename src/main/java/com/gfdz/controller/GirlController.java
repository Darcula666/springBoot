package com.gfdz.controller;

import com.gfdz.entity.GirlEntity;
import com.gfdz.entity.ResultEntity;
import com.gfdz.repository.GirlRepository;
import com.gfdz.service.GirlService;
import com.gfdz.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/girls")
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
    @ApiOperation(value = "获取用户列表",notes = "")
    @GetMapping
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
    @ApiOperation(value = "添加一个女生",notes = "")
    @ApiImplicitParam(name = "girl",value = "girl实体",required = true)
    @PostMapping
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
    @ApiOperation(value = "查询一个女生",notes = "通过url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "girl实体ID",required = true,dataType = "Long")
    @GetMapping(value = "/{id}")
    public GirlEntity girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新
     *
     * @return
     */
    @ApiOperation(value = "新一个女生",notes = "通过url的id来指定更新对象，并根据传过来的gril信息来更新girl详细信息")
    @ApiImplicitParam(name = "id",value = "girl实体ID",required = true,dataType = "Long")
    @PutMapping(value = "/{id}")
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
    @ApiOperation(value = "删除一个女生",notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id",value = "girl实体ID",required = true,dataType = "Long")
    @DeleteMapping(value = "{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生列表
     *
     * @param age
     */
    @ApiOperation(value = "删除一个女生",notes = "根据url的年龄查询女生")
    @ApiImplicitParam(name = "age",value = "girl实体年龄",required = true,dataType = "Long")
    @GetMapping(value = "/age/{age}")
    public List<GirlEntity> girlListByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }

    @ApiOperation(value = "获取一个女生的age",notes = "根据url的id查询女生的age")
    @ApiImplicitParam(name = "age",value = "girl实体年龄",required = true,dataType = "Long")
    @GetMapping(value = "/getage/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
       girlService.getAge(id);
    }

}
