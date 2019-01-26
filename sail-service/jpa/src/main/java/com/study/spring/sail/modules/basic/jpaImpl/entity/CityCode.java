package com.study.spring.sail.modules.basic.jpaImpl.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 *  city_code 城市代码表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Entity
@Data
@Table(name = "city_code")
public class CityCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "parent_id")
    private Long parentId;                                       // 父id
    @Column(name = "short_name")
    private String shortName;                                   // 简称
    @Column(name = "name")
    private String name;                                         // 名称
    @Column(name = "merger_name")
    private String mergerName;                                  // 全称
    @Column(name = "level")
    private Integer level;                                       // 层级 0 1 2 省市区县
    @Column(name = "pinyin")
    private String pinyin;                                      // 拼音
    @Column(name = "code")
    private String code;                                        // 长途区号
    @Column(name = "zip_code")
    private String zipCode;                                     // 邮编
    @Column(name = "first")
    private String first;                                       // 首字母
    @Column(name = "lng")
    private String lng;                                         // 经度
    @Column(name = "lat")
    private String lat;                                         // 纬度

}
