package me.tairy.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-05 15:16
 */
public class SQLReplace {

    private static String mysqlToPgSql(String mysql) {
        String[] mysqlStrArr = mysql.split(" ");
        String[] keyWords = {"=", "like"};
        Deque<String> queue = new ArrayDeque<String>();
        int paramIndex = 1;

        for (String strItem : mysqlStrArr) {
            int markIndex = strItem.indexOf("?");
            if (markIndex == 0) {
                if (Arrays.asList(keyWords).contains(queue.getFirst())) {
                    queue.push("$" + paramIndex);
                    paramIndex++;
                } else {
                    queue.push(strItem);
                }
            } else {
                queue.push(strItem);
            }
        }

        StringBuilder sb = new StringBuilder();

        int size = queue.size();

        for (int i = 0; i < size; i++) {
            sb.append(queue.pollLast());
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mysqlToPgSql("select * from tbl where col1 = ? and (col2 = ? or col3 like ?) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = ?"));
    }
}
