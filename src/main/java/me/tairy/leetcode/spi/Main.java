package me.tairy.leetcode.spi;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * package: me.tairy.leetcode.spi
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-01 11:15
 */
public class Main {

    public static void main(String[] args) {

        DriverManager.getDrivers();

        ServiceLoader<Search> searches = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = searches.iterator();
        while (iterator.hasNext()) {
            Search search = iterator.next();
            search.searchDoc("hello world!");
        }
    }
}
