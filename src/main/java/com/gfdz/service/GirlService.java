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

    public Integer getAge(String id) throws Exception {
        GirlEntity girl = girlRepository.findById(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回“你还在上小学吧” code:100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //你可能已经上初中了 code:101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        return age;
    }
     /**
      *                                         ,s555SB@@&
      *                                      :9H####@@@@@Xi
      *                                     1@@@@@@@@@@@@@@8
      *                                   ,8@@@@@@@@@B@@@@@@8
      *                                  :B@@@@X3hi8Bs;B@@@@@Ah,
      *             ,8i                  r@@@B:     1S ,M@@@@@@#8;
      *            1AB35.i:               X@@8 .   SGhr ,A@@@@@@@@S
      *            1@h31MX8                18Hhh3i .i3r ,A@@@@@@@@@5
      *            ;@&i,58r5                 rGSS:     :B@@@@@@@@@@A
      *             1#i  . 9i                 hX.  .: .5@@@@@@@@@@@1
      *              sG1,  ,G53s.              9#Xi;hS5 3B@@@@@@@B1
      *               .h8h.,A@@@MXSs,           #@H1:    3ssSSX@1
      *               s ,@@@@@@@@@@@@Xhi,       r#@@X1s9M8    .GA981
      *               ,. rS8H#@@@@@@@@@@#HG51;.  .h31i;9@r    .8@@@@BS;i;
      *                .19AXXXAB@@@@@@@@@@@@@@#MHXG893hrX#XGGXM@@@@@@@@@@MS
      *                s@@MM@@@hsX#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,
      *              :GB@#3G@@Brs ,1GM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B,
      *            .hM@@@#@@#MX 51  r;iSGAM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@8
      *          :3B@@@@@@@@@@@&9@h :Gs   .;sSXH@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:
      *      s&HA#@@@@@@@@@@@@@@M89A;.8S.       ,r3@@@@@@@@@@@@@@@@@@@@@@@@@@@r
      *   ,13B@@@@@@@@@@@@@@@@@@@5 5B3 ;.         ;@@@@@@@@@@@@@@@@@@@@@@@@@@@i
      *  5#@@#&@@@@@@@@@@@@@@@@@@9  .39:          ;@@@@@@@@@@@@@@@@@@@@@@@@@@@;
      *  9@@@X:MM@@@@@@@@@@@@@@@#;    ;31.         H@@@@@@@@@@@@@@@@@@@@@@@@@@:
      *   SH#@B9.rM@@@@@@@@@@@@@B       :.         3@@@@@@@@@@@@@@@@@@@@@@@@@@5
      *     ,:.   9@@@@@@@@@@@#HB5                 .M@@@@@@@@@@@@@@@@@@@@@@@@@B
      *           ,ssirhSM@&1;i19911i,.             s@@@@@@@@@@@@@@@@@@@@@@@@@@S
      *              ,,,rHAri1h1rh&@#353Sh:          8@@@@@@@@@@@@@@@@@@@@@@@@@#:
      *            .A3hH@#5S553&@@#h   i:i9S          #@@@@@@@@@@@@@@@@@@@@@@@@@A.
      *
      *
      *    又看源码，看你妹妹呀！
      */
    /**
     * 通过姓名查询一个女生信息
     */
    public GirlEntity findByName(String name) {
        return girlRepository.findByName(name);
    }
}
