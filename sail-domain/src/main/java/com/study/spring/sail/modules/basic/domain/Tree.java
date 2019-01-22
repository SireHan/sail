package com.study.spring.sail.modules.basic.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 韩炜
 * @date 2019-01-22 17:13
 */
public class Tree<T> implements Serializable {
    public String value;
    public String label;
    public boolean loading;
    public List<Tree> children;
    public T node;
}
