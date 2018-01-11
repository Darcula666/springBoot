package com.gfdz.repository;

import com.gfdz.entity.GirlEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Created by Administrator on 2017/3/26.
 */

public interface GirlRepository extends JpaRepository<GirlEntity,Integer> {
    //通过年龄查询
     List<GirlEntity> findByAge(Integer age);

     GirlEntity findByName(String name);
     GirlEntity findById(String id);
    GirlEntity save(GirlEntity girl);

    @Override
    Page<GirlEntity> findAll(Pageable pageable);
}
