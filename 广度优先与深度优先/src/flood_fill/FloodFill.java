package flood_fill;

/**
 * 图像渲染
 * <p>
 * 有一幅以m x n的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。
 * <p>
 * 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素image[sr][sc]开始对图像进行 上色填充 。
 * <p>
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为newColor。
 * <p>
 * 最后返回 经过上色渲染后的图像
 * <p>
 * 示例 1:
 * <p>
 * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 示例 2:
 * <p>
 * 输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * 输出: [[2,2,2],[2,2,2]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FloodFill {

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。
     * <p>
     * 空间复杂度：O(1) 原地解法 ，只用了一个额外int存储对比色。
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int compareColor = image[sr][sc];
        if (compareColor == color) {
            return image;
        }
        dfsColoringImage(image, sr, sc, color, compareColor);
        return image;
    }

    private void dfsColoringImage(int[][] image, int sr, int sc, int color, int compareColor) {
        if (image.length > sr && sr >= 0 && image[0].length > sc && sc >= 0) {
            if (image[sr][sc] == compareColor) {
                image[sr][sc] = color;
                // 深度遍历 上下左右
                dfsColoringImage(image, sr + 1, sc, color, compareColor);
                dfsColoringImage(image, sr - 1, sc, color, compareColor);
                dfsColoringImage(image, sr, sc + 1, color, compareColor);
                dfsColoringImage(image, sr, sc - 1, color, compareColor);
            }
        }
    }

}
