package max_area_of_island;

/**
 * 岛屿最大面积
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland {

    /**
     * 深度优先搜索-复杂度分析
     * <p>
     * 时间复杂度：O(m×n)。其中 m 是给定网格中的行数，n 是列数。我们访问每个网格最多一次。
     * <p>
     * 空间复杂度：O(m×n)，递归的深度最大可能是整个网格的大小，因此最大可能使用 O(m×n) 的栈空间。
     */
    public int maxAreaOfIsland(int[][] grid) {
        // 地图 m * n 模型
        int m = grid[0].length;
        int n = grid.length;
        // 初始化全图最大面积 与 单点最大面积
        int max = 0;
        int pointMax = 0;

        // 模型遍历
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] == 1) {
                    pointMax = maxAreaOfPoint(grid, x, y, 0);
                }
                max = Math.max(max, pointMax);
            }
        }

        return max;
    }

    private int maxAreaOfPoint(int[][] grid, int x, int y, int initSize) {
        if (grid[0].length > x && x >= 0 && grid.length > y && y >= 0) {
            if (grid[y][x] == 1) {
                ++initSize;
                // 避免重复搜索
                grid[y][x] = 0;
                // dfs 上下左右
                initSize = maxAreaOfPoint(grid, x, y - 1, initSize);
                initSize = maxAreaOfPoint(grid, x, y + 1, initSize);
                initSize = maxAreaOfPoint(grid, x - 1, y, initSize);
                initSize = maxAreaOfPoint(grid, x + 1, y, initSize);
            }
        }
        return initSize;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        maxAreaOfIsland.maxAreaOfIsland(grid);
    }
}
