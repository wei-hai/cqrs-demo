package test.java.com.solution;

import main.java.com.solution.Solution;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8));
        Integer target = 10;
        ArrayList<ArrayList<Integer>> result = solution.twoSum(nums, target);
        ArrayList<ArrayList<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(new ArrayList<>(Arrays.asList(2,8)));
        expectedOutput.add(new ArrayList<>(Arrays.asList(3,7)));
        expectedOutput.add(new ArrayList<>(Arrays.asList(4,6)));
        expectedOutput.add(new ArrayList<>(Arrays.asList(5,5)));
        Assert.assertEquals(result, expectedOutput);
        Solution mockedSolution = Mockito.mock(Solution.class);
        Mockito.when(mockedSolution.twoSum(null, null)).thenReturn(null);
        Assert.assertEquals(mockedSolution.twoSum(null, null), null);
    }
}
