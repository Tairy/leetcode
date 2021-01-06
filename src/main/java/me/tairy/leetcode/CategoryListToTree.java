package me.tairy.leetcode;

import sun.applet.AppletClassLoader;
import sun.misc.Launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class CategoryListToTree {
    public static void main(String[] args) {
        List<CategoryItem> items = new ArrayList<>();
        items.add(new CategoryItem(1, "家电", -1));
        items.add(new CategoryItem(2, "女装", -1));
        items.add(new CategoryItem(3, "冰箱", 1));
        items.add(new CategoryItem(4, "连衣裙", 2));
        items.add(new CategoryItem(5, "连衣裙2", 4));

        CategoryNode root = generateCategoryTree(items);
        ClassLoader.getSystemClassLoader();
        Launcher launcher = Launcher.getLauncher();
        ClassLoader extClassLoader = Launcher.getLauncher().getClassLoader();
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println("Hello World!");
    }

    private static class CategoryItem {
        int id;
        String name;
        int parentId;



        CategoryItem(int id, String name, int parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }
    }

    private static class CategoryNode {
        int id;
        String name;
        List<CategoryNode> children;

        CategoryNode(int id, String name) {
            this.id = id;
            this.name = name;
            this.children = new ArrayList<CategoryNode>();
        }

        CategoryNode(CategoryItem item) {
            this.id = item.id;
            this.name = item.name;
            this.children = new ArrayList<CategoryNode>();
        }
    }

    private static CategoryNode generateCategoryTree(List<CategoryItem> dbItems) {
        Map<Integer, CategoryNode> cateItemMap = new HashMap<Integer, CategoryNode>(16);
        CategoryNode root = new CategoryNode(-1, "root");

        cateItemMap.put(-1, root);

        for (CategoryItem item : dbItems) {
            cateItemMap.put(item.id, new CategoryNode(item));
        }

        for (CategoryItem item : dbItems) {
            cateItemMap.get(item.parentId).children.add(cateItemMap.get(item.id));
        }

        return cateItemMap.get(-1);
    }
}