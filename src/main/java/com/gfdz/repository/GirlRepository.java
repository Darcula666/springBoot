package com.gfdz.repository;

import com.gfdz.entity.GirlEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Created by Administrator on 2017/3/26.
 */
@CacheConfig(cacheNames = "girls")
public interface GirlRepository extends JpaRepository<GirlEntity,Integer> {
    //通过年龄查询
     List<GirlEntity> findByAge(Integer age);
    @Cacheable(key = "#p0")
     GirlEntity findByName(String name);
     GirlEntity findById(String id);
    @CachePut(key = "#p0.name")
    GirlEntity save(GirlEntity girl);
}
