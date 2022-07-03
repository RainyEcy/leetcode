import java.util.ArrayList;

public class Kruskal {

    /**
     * 顶点数量
     */
    int vertexNum;

    ArrayList<EWeight> eWeightList;

    /**
     * 边集数组
     */
    class EWeight {
        Integer begin;
        Integer end;
        Integer weight;
    }

    public Kruskal(int vertexNum, ArrayList<EWeight> eWeightList) {
        this.vertexNum = vertexNum;
        this.eWeightList = eWeightList;
    }

    /**
     * 最小生成树-Kruskal算法
     */
    public void kruskal() {
        // 初始化所有顶点的parent值
        int[] parent = new int[vertexNum];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        // 循环所有边
        for (int i = 0; i < eWeightList.size(); i++) {
            EWeight eWeight = eWeightList.get(i);

            // 判断边是否存在环路
            int beginParent = getParent(eWeight.begin, parent);
            int endParent = getParent(eWeight.end, parent);
            if (endParent != beginParent) {
                parent[beginParent] = endParent;
            }
        }
    }

    private int getParent(int num, int[] parent) {
        while (parent[num] != -1) {
            num = parent[num];
        }
        return num;
    }
}
