package com.yzg.leetcode;

public class L474 {
    /**
     * 474. 一和零
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * <p>
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     * <p>
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
     * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
     * 示例 2：
     * <p>
     * 输入：strs = ["10", "0", "1"], m = 1, n = 1
     * 输出：2
     * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 600
     * 1 <= strs[i].length <= 100
     * strs[i] 仅由 '0' 和 '1' 组成
     * 1 <= m, n <= 100
     */

    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示最多有i个0和j个1的最大子集数
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] zeroAndOne = getZeroAndOne(str);
            for (int i = m; i >= zeroAndOne[0]; i--) {
                for (int j = n; j >= zeroAndOne[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroAndOne[0]][j - zeroAndOne[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int[] getZeroAndOne(String str) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }
        return new int[]{zero, one};
    }
}
