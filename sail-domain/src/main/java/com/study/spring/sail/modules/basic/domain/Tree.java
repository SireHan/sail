package com.study.spring.sail.modules.basic.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author 韩炜
 * @date 2019-01-22 17:13
 */
public class Tree<T> implements Serializable {
    public String value;
    public String label;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean loading;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Tree> children;
    public T node;
}
