package 腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

public class BadOrange {

    // 曼哈顿路线
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 多源广度优先搜索
     * 复杂度分析
     * 时间复杂度：O(nm)
     * 即进行一次广度优先搜索的时间，其中 n=grid.lengthn=grid.length, m=grid[0].lengthm=grid[0].length 。
     * 空间复杂度：O(nm)
     * 需要额外的 dis 数组记录每个新鲜橘子被腐烂的最短时间，大小为 O(nm)，且广度优先搜索中队列里存放的状态最多不会超过 nm 个，最多需要
     * O(nm) 的空间，所以最后的空间复杂度为 O(nm)。
     */
    public int orangesRotting(int[][] grid) {
        int xLength = grid[0].length;
        int yLength = grid.length;

        Queue<int[]> badOrangePoint = new LinkedList();
        int goodOrangeNum = 0;
        int minutes = 0;

        // 首次遍历找到所有糜烂的橘子位置 与 好橘子个数
        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                if (grid[y][x] == 1) {
                    // 好橘子数量+1
                    goodOrangeNum++;
                } else if (grid[y][x] == 2) {
                    // 坏橘子位置+1
                    badOrangePoint.add(new int[]{y, x});
                }
            }
        }

        // 好橘子个数为0 - 没有新鲜橘子返回 0
        if (goodOrangeNum == 0) {
            return 0;
        }
        // 好橘子不为0 腐烂的橘子为0 - 返回不可能 -1
        if (badOrangePoint.isEmpty()) {
            return -1;
        }

        // 坏橘子作为源进行BFS逐层遍历 找过的进行标识
        int levelSize = 0;
        while (!badOrangePoint.isEmpty() && goodOrangeNum > 0) {
            // 初始化广度层数量
            levelSize = badOrangePoint.size();
            // 完成一轮广度搜索 时间+1
            minutes++;
            for (int j = 0; j < levelSize; j++) {
                int[] point = badOrangePoint.poll();
                int badY = point[0];
                int badX = point[1];
                for (int i = 0; i < dirs.length; i++) {
                    int addY = dirs[i][0] + badY;
                    int addX = dirs[i][1] + badX;
                    // 位置临界值判断
                    if (0 <= addY && addY < yLength && addX < xLength && 0 <= addX) {
                        // 好橘子1被传染 a 改为2并入队列 b 好橘子数量-1
                        // 无橘子0和坏橘子2 不做处理
                        int bfsOrange = grid[addY][addX];
                        if (bfsOrange == 1) {
                            goodOrangeNum--;
                            grid[addY][addX] = 2;
                            badOrangePoint.add(new int[]{addY, addX});
                        }
                    }
                }
            }
        }

        // 好橘子数量为0都被传染返回时间minutes， 否则返回-1
        if (goodOrangeNum == 0) {
            return minutes;
        } else {
            return -1;
        }

    }

}
