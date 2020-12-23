package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/23 下午3:59
 */
public class SumWithRecursion {

    /**
     * 基本递归
     *
     * @param x 参数
     * @return 结果
     */
    private int sumWithRecursionFromXToOne(int x) {
        if (x < 1) {
            return 0;
        }
        return x + sumWithRecursionFromXToOne(x - 1);
    }

    /**
     * 尾递归
     *
     * @param x   参数
     * @param sum 结果缓存
     * @return 结果
     */
    private int sumWithTailRecursion(int x, int sum) {
        sum += x;
        if (x < 1) {
            return sum;
        }
        return sumWithTailRecursion(x - 1, sum);
    }

    /**
     * 阶乘 会溢出
     *
     * @param x       x
     * @param product 乘积
     * @return 结果
     */
    private int factorialWithTailRecursion(int x, int product) {
        if (x < 0) {
            return 0;
        } else if (x == 0) {
            return 1;
        } else if (x == 1) {
            return product;
        } else {
            return factorialWithTailRecursion(x - 1, x * product);
        }
    }

    public static void main(String[] args) {
        SumWithRecursion sumWithRecursion = new SumWithRecursion();
        System.out.printf("sum: %d\n", sumWithRecursion.sumWithRecursionFromXToOne(100));
        System.out.printf("sum: %d\n", sumWithRecursion.sumWithTailRecursion(100, 0));
        System.out.printf("product: %d\n", sumWithRecursion.factorialWithTailRecursion(4, 1));
    }
}