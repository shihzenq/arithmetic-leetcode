package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day50;

/**
 * 547. 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * <p>
 * 并查集
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class FindCircleNumFour {

    public static void main(String[] args) {
        FindCircleNumFour findCircleNum = new FindCircleNumFour();
        int circleNum = findCircleNum.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UFFour uf = new UFFour(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }


    class UFFour {
        // 数量
        private int count;

        // 树形
        private int[] parents;

        // 记录每棵树包含的节点数
        private int[] size;

        public UFFour(int count) {
            this.count = count;
            parents = new int[count];
            size = new int[count];
            for (int i = 0; i < count; i++) {
                parents[i] = i;
                size[i] = 1;

            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] > size[rootQ]) {
                parents[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parents[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        private int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public int getCount() {
            return count;
        }
    }
}
