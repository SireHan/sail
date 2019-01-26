package com.study.spring.sail.modules.basic.domain;

/**
 * JOPO 对象转换成Tree 所要实现的接口
 *
 * @author 韩炜
 * @date 2019-01-22 17:19
 */
public interface TransTree<T> {
    Tree<T> transTree();
}
