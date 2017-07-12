package com.gfdz.controller;

import com.gfdz.entity.GirlEntity;
import com.gfdz.entity.ResultEntity;
import com.gfdz.utils.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Administrator on 2017/4/14.
 */
@RequestMapping("/fileUpload")
@RestController
public class FileUploadController {
    /**
     * 文件上传初始页面
     *
     * @param
     * @return
     * @Valid:验证
     */
    @GetMapping("/file")
    public ModelAndView index() {
        return new ModelAndView("file");
    }
}
