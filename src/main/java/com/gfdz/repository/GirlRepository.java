package com.gfdz.repository;

import com.gfdz.entity.GirlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/26.
 */
public interface GirlRepository extends JpaRepository<GirlEntity,Integer> {
    //通过年龄查询
    public List<GirlEntity> findByAge(Integer age);

    public GirlEntity findByName(String name);
    public GirlEntity findById(String id);
}
