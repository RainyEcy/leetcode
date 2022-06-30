import java.util.Arrays;

public class Prim {
    /**
     * 最小生成树-Prim普里姆算法
     */
    public static int[] prim(int[][] g) {
        // 以基准点V0起点 初始化v0到各点位距离
        int[] vWeight = Arrays.copyOf(g[0], g.length);

        // 初始化格起点位置均为0标
        int[] adjVex = new int[g.length];

        /**
         * 循环次数：
         *  1） for循环： 顶点数-1
         *  2） while循环 ：定义布尔数组，找到后改状态直到状态全部成功
         */
        for (int v = 1; v < g.length; v++) {
            // 找到当前最短路径与最短路径下标点
            int min = Integer.MAX_VALUE, minPoint = 0;
            for (int i = 1; i < vWeight.length; i++) {
                // 0 说明已找到无需重复
                if (vWeight[i] > 0 && min > vWeight[i]) {
                    min = vWeight[i];
                    minPoint = i;
                }
            }

            // 打印当前位置，当前位置最短路径已找到将权重置为零
            System.out.println(String.format("起点%s - 到达%s : 距离%s", adjVex[minPoint], minPoint, min));
            vWeight[minPoint] = 0;

            // 将当前位置更新为基准点，更新各点位最短距离
            for (int j = 1; j < g.length; j++) {
                if (g[minPoint][j] < vWeight[j]) {
                    // 更新最短距路
                    vWeight[j] = g[minPoint][j];
                    // 更新边起终点
                    adjVex[j] = minPoint;
                }
            }
        }

        return adjVex;
    }

    /**
     * System.out
     * 起点0 - 到达1 : 距离10
     * 起点0 - 到达5 : 距离11
     * 起点1 - 到达8 : 距离12
     * 起点8 - 到达2 : 距离8
     * 起点1 - 到达6 : 距离16
     * 起点6 - 到达7 : 距离19
     * 起点7 - 到达4 : 距离7
     * 起点7 - 到达3 : 距离16
     */
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[] v0 = {0, 10, max, max, max, 11, max, max, max};
        int[] v1 = {10, 0, 18, max, max, max, 16, max, 12};
        int[] v2 = {max, 18, 0, 22, max, max, max, max, 8};
        int[] v3 = {max, max, 22, 0, 20, max, max, 16, 21};
        int[] v4 = {max, max, max, 20, 0, 26, max, 7, max};
        int[] v5 = {11, max, max, max, 26, 0, 17, max, max};
        int[] v6 = {max, 16, max, max, max, 17, 0, 19, max};
        int[] v7 = {max, max, max, 16, 7, max, 19, 0, max};
        int[] v8 = {max, 12, 8, 21, max, max, max, max, 0};

        int[][] graph = {v0, v1, v2, v3, v4, v5, v6, v7, v8};

        prim(graph);


    }
}
