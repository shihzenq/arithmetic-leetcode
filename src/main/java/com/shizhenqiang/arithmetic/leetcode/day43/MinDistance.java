package com.shizhenqiang.arithmetic.leetcode.day43;


/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class MinDistance {


    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        int distance = minDistance.minDistance("", "a");
        System.out.println(distance);
    }

    /**
     * dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
     * <p>
     * 所以，
     * <p>
     * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
     * <p>
     * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * <p>
     * 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
     * <p>
     * 作者：powcai
     * 链接：https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        for (int i = 0; i <= m; i++) dp[i][0] = i;

        for (int j = 1; j <= n; j++) dp[0][j] = j;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = dp[i][j];
                    int b = dp[i][j+1];
                    int c = dp[i +1] [j];
                    dp[i + 1][j+1] = a < b ? Math.min(a, c) : Math.min(b, c);
                    dp[i + 1][j + 1] ++;
                }
            }
        }

        return dp[m][n];
    }
}
