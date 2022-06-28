package 全排列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {


    /**
     * 边界: nums.length = 0 || 1
     * 剪枝：访问过的排除
     * 数据结构：树的dfs遍历 前置遍历
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        Deque<Integer> intList = new ArrayDeque<>();
        boolean[] intStatus = new boolean[nums.length];

        permuteDfs(nums, intStatus, intList, returnList);

        return returnList;
    }

    public void permuteDfs(int[] nums, boolean[] intStatus, Deque<Integer> intList, ArrayList<List<Integer>> returnList) {
        // 满足条件入集合
        if (intList.size() == nums.length) {
            returnList.add(new ArrayList<>(intList));
        }

        // 循环dfs深度
        for (int j = 0; j < nums.length; j++) {
            if (!intStatus[j]) {
                intList.offerLast(nums[j]);
                intStatus[j] = true;

                permuteDfs(nums, intStatus, intList, returnList);

                intList.removeLast();
                intStatus[j] = false;
            }
        }
    }
}
