package com.study.spring.sail.modules.basic.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class City implements TransTree<City>, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long parentId;                                       // 父id
    private String shortName;                                   // 简称
    private String name;                                         // 名称
    private String mergerName;                                  // 全称
    private Integer level;                                       // 层级 0 1 2 省市区县
    private String pinyin;                                      // 拼音
    private String code;                                        // 长途区号
    private String zipCode;                                     // 邮编
    private String first;                                       // 首字母
    private String lng;                                         // 经度
    private String lat;                                         // 纬度

    @Override
    public Tree<City> transTree() {
        Tree tree = new Tree();
        tree.label = this.name;
        tree.value = id+"";
        tree.node = this;
        if(this.level!=3){
            tree.loading = false;
            tree.children = new ArrayList<>();
        }
        return tree;
    }
}
