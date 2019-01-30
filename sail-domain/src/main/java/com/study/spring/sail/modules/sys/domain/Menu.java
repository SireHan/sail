package com.study.spring.sail.modules.sys.domain;

import com.study.spring.sail.common.base.BaseEntity;
import com.study.spring.sail.modules.basic.domain.City;
import com.study.spring.sail.modules.basic.domain.TransTree;
import com.study.spring.sail.modules.basic.domain.Tree;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * sys_menu 系统菜单表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class Menu implements TransTree<Menu> {

    private static final long serialVersionUID = 1L;
    private static final long ROOTID = 1;                     // 根目录
    private static final String MENU_NOLEAF = "1";            // 菜单（含有子节点）
    private static final String MENU_LEAF = "2";              // 菜单（不含有子节点）

    private Long id;
    private Long parentId;                                      // 父菜单id
    private String menuName;                                    // 菜单名称
    private String menuCode;                                    // 菜单代码
    private String menuHref;                                    // 菜单访问路径
    private Integer menuTarget;                                // 菜单打开方式
    private String menuIcon;                                   // 菜单图标
    private String menuStatus;                                 // 菜单状态
    private String menuType;                                   // 菜单类型

    @Override
    public Tree<Menu> transTree() {
        Tree tree = new Tree();
        tree.label = this.menuName;
        tree.value = id + "";
        tree.node = this;
        // 默认省县乡 三级结构
        if (MENU_NOLEAF.equals(this.menuType)) {
            tree.loading = false;
            tree.children = new ArrayList<>();
        }
        return tree;
    }

    public static Tree<Menu> transTree(Menu parent, List<Menu> menuList) {
        // parent == null 查找根节点 系统只有一个菜单的根级目录
        if (parent == null) {
            Menu root = null;
            for (Menu menu : menuList) {
                if (menu.getId() == ROOTID) {
                    root = menu;
                    break;
                }
            }
            if (root != null) {
                Tree<Menu> tree = root.transTree();
                if (tree.children == null) {
                    return tree;
                } else {
                    tree.children = transTree(root, menuList).children;
                    return tree;
                }
            }
            return null;
        } else {
            Tree<Menu> tree = parent.transTree();
            List<Tree> children = null;
            for (Menu menu : menuList) {
                if (menu.getParentId() == parent.getId()) {
                    if (children == null) {
                        children = new ArrayList<>();
                    }
                    Tree<Menu> childTree = menu.transTree();
                    if (childTree.children != null) {
                        childTree.children = transTree(menu, menuList).children;
                    }
                    children.add(childTree);
                }
            }
            tree.children = children;
            return tree;
        }
    }


}
