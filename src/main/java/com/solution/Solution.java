package main.java.com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
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
}
