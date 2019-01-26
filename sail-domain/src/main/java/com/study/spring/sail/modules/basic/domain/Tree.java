package com.study.spring.sail.modules.basic.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * 系统统一Tree 结构
 *
 * @author 韩炜
 * @date 2019-01-22 17:13
 */
public class Tree<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public String value;                                    // 名称
    public String label;                                    // 值

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean loading;                                 // 是否加载中 为空不进行json 序列化

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Tree> children;                             // 子集 为空不进行json 序列化

    public T node;                                           // 节点信息
}
