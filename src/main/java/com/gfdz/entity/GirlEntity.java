package com.gfdz.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2017/3/25.
 */
@Entity
@Table(name = "t_girl")
public class GirlEntity {
    private String id;
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;
    private String name;

    public GirlEntity() {
    }

    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "girl_seq")
    //@SequenceGenerator(sequenceName = "girl_seq", allocationSize = 1, name = "girl_seq")
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column
    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GirlEntity{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
