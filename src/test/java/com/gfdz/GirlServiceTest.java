package com.gfdz;

import com.gfdz.entity.GirlEntity;
import com.gfdz.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/3/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        GirlEntity girl=girlService.findOne(10);
        Assert.assertEquals(new Integer(22),girl.getAge());
    }

}
