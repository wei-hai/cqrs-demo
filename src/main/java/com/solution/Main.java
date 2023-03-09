package main.java.com.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 5, 6, 8, 8));
        Integer target = 10;
        ArrayList<ArrayList<Integer>> result = solution.twoSum(nums, target);
        System.out.println(result);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        System.out.println(solution.minCostDFS(node1));
    }

    public void numOfIslands() {
        Solution solution = new Solution();
        int[][] islands = {
                {1, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 0, 0}};
        int num = solution.numIslands(islands);
        System.out.println(num);
    }

    public void minCost() {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        System.out.println(solution.minCostDFS(node1));
    }
}