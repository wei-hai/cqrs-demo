package main.java.com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    private Integer result;
    private ArrayList path;

    public ArrayList<ArrayList<Integer>> twoSum(ArrayList<Integer> nums, Integer target) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (Integer num : nums) {
            Integer val = counter.getOrDefault(num, 0);
            counter.put(num, val + 1);
        }
        System.out.println(counter);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (Integer num1 : nums) {
            Integer num2 = target - num1;
            Integer val1 = counter.getOrDefault(num1, 0);
            Integer val2 = counter.getOrDefault(num2, 0);
            if (num1 != num2 && val1 > 0 && val2 > 0) {
                result.add(new ArrayList<>(Arrays.asList(num1, num2)));
                counter.put(num1, val1 - 1);
                counter.put(num2, val2 - 1);
            } else if (num1 == num2 && val1 >= 2) {
                result.add(new ArrayList<>(Arrays.asList(num1, num2)));
                counter.put(num1, val1 - 2);
            }
        }
        return result;
    }

    public int numIslands(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                this.dfs(matrix, m, n, i, j, visited);
                result += 1;
            }
        }
        return result;
    }

    public void dfs(int[][] matrix, int m, int n, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
        this.dfs(matrix, m, n, x - 1, y, visited);
        this.dfs(matrix, m, n, x + 1, y, visited);
        this.dfs(matrix, m, n, x, y - 1, visited);
        this.dfs(matrix, m, n, x, y + 1, visited);
    }

    public Integer minCostDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = Integer.MAX_VALUE;
        this.minCostDFSHelper(root, 0, new ArrayList<>());
        System.out.println(path);
        return result;
    }

    private void minCostDFSHelper(TreeNode node, int tempCost, ArrayList<Integer> tempPath) {
        if (tempCost > result) {
            return;
        }
        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            if (result > tempCost + node.getValue()) {
                result = tempCost + node.getValue();
                tempPath.add(node.getValue());
                path = (ArrayList) tempPath.clone();
            }
            return;
        }
        tempPath.add(node.getValue());
        this.minCostDFSHelper(node.getLeft(), tempCost + node.getValue(), tempPath);
        tempPath.remove(tempPath.size() - 1);
        this.minCostDFSHelper(node.getRight(), tempCost + node.getValue(), tempPath);
    }

    public Integer minCostBFS(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.getLeft() == null && node.getRight() == null) {
                }
            }
        }
        return result;
    }
}
