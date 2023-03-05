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
    }
}