package me.tairy.leetcode.spi;

import java.sql.DriverManager;
import java.util.List;

/**
 * package: me.tairy.leetcode.spi
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-01 11:13
 */
public class DBSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("DB 搜索：" + keyword);
        return null;
    }
}
