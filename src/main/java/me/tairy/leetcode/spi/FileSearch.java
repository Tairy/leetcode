package me.tairy.leetcode.spi;

import java.util.List;

/**
 * package: me.tairy.leetcode.spi
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-01 11:12
 */
public class FileSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索：" + keyword);
        return null;
    }
}
