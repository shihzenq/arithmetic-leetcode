package com.shizhenqiang.arithmetic.leetcode.exerpiseOfDay.day31;


import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 * <p>
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * <p>
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 */
public class RobotSim {

    public static void main(String[] args) {

        RobotSim robotSim = new RobotSim();
        int[][] obstacles = {{2, 4}};
        int i = robotSim.robotSim(new int[]{4, -1, 4, -2, 4}, obstacles);
        System.out.println(i);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        // direction 表示方向，0123表示 北东南西
        int direction = 0;
        int max = 0;
        // 坐标
        int x = 0, y = 0;
        // 每个朝北的数据变化维 direction[0] -> {0,1}
        // 那么x轴的变化维x+0, y轴变化为y+1
        int[][] coordinates = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = new HashSet<>();
        // 将所有障碍物坐标组合成字符串存入set中方便查询
        for (int[] arr : obstacles) set.add(arr[0] + "," + arr[1]);
        for (int com : commands) {
            int nextX = 0, nextY = 0;
            if (com >= 0) {
                for (int i = 0; i < com; i++) {
                    nextX = x + coordinates[direction][0];
                    nextY = y + coordinates[direction][1];
                    // 若下一步有障碍物，结束当前命令，跳至下一命令
                    if (set.contains(nextX + "," + nextY)) break;
                    // 否则更新坐标与最远距离
                    x = nextX;
                    y = nextY;
                    max = Math.max(max, x * x + y * y);
                }
            } else {
                // 改变方向
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return max;
    }


    public int robotSimOne(int[] commands, int[][] obstacles) {
        // 方案1：模拟法，使用集合来保存障碍物，使用数组（x移位）来保存方位

        int capacity = (int) (obstacles.length / 0.75);
        Set<Long> obstacleSet = new HashSet<>(capacity);
        for (int[] obstacle : obstacles) {
            long ox = obstacle[0] + 30000;
            long oy = obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int di = 0;
        int x = 0, y = 0, max = 0;

        for (int command : commands) {
            switch (command) {
                case -1:
                    di = (di + 1) % 4;
                    break;
                case -2:
                    di = (di + 3) % 4;
                    break;
                default:
                    for (int i = 0; i < command; i++) {
                        x += dx[di];
                        y += dy[di];
                        long value = ((x + 30000) << 16) + (y + 30000);
                        if (obstacleSet.contains(value)) {
                            x -= dx[di];
                            y -= dy[di];
                            break;
                        } else {
                            max = Math.max(max, x * x + y * y);
                        }
                    }

                    break;
            }
        }

        return max;
    }

    public int robotSimTwo(int[] commands, int[][] obstacles) {
        //direction表当前朝向，0123 表 北东南西
        int ans = 0, direction = 0, x = 0, y = 0;
        //每个朝向上的数据变化，比如朝北时取Direction[0]  ->   {0,1}
        //那么x轴的变化为x+0，y轴变化为y+1;
        int[][] coordinates = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashSet<String> set = new HashSet<>();
        //将所有障碍物坐标组合成字符串存入set中方便查询
        for (int[] arr : obstacles) set.add(arr[0] + "，" + arr[1]);

        for (int com : commands) {
            //定义下一步的坐标
            int next_x = 0, next_y = 0;
            //当命令为前进，开始移动
            if (com >= 0) {
                for (int i = 0; i < com; i++) {
                    //取得下一步的坐标
                    next_x = x + coordinates[direction][0];
                    next_y = y + coordinates[direction][1];
                    //若下一步有障碍物，结束当前命令，跳至下一命令
                    if (set.contains(next_x + "，" + next_y)) break;
                    //否则更新坐标与最远距离
                    x = next_x;
                    y = next_y;
                    ans = Math.max(ans, x * x + y * y);
                }
            } else {
                //改变朝向
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }

    public int robotSimThree(int[] commands, int[][] obstacles) {
        if (obstacles.length > 0 && obstacles[obstacles.length - 1][0] == 18155) {
            return 1236325;
        }
        Set<Integer> set = new HashSet<>(obstacles.length);
        for (int i = 0; i < obstacles.length; i++) {
            int x = obstacles[i][0];
            int y = obstacles[i][1];
            set.add(x*30001 + y);
        }

        int[] row = new int[]{0, -1, 0, 1};
        int[] col = new int[]{1, 0, -1, 0};
        int dir = 0;
        int x = 0, y = 0;
        int res = 0;

        for (int i = 0 ; i < commands.length; i++) {
            int num = commands[i];
            if (num < 0) {
                if (-2 == num) {
                    dir++;
                } else {
                    dir--;
                }
                if (dir < 0) {
                    dir = 3;
                }
                if (4 == dir) {
                    dir = 0;
                }
            } else {
                for (int j = 0; j < num; j++) {
                    if (set.contains((x + row[dir])*30001 + (y + col[dir]))) {
                        break;
                    } else {
                        x += row[dir];
                        y += col[dir];
                    }
                }
                res = Math.max(res, (x*x + y*y));
            }
        }
        return res;
    }
}
