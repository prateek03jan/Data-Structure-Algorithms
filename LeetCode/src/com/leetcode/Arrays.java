package com.leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Arrays {
    /*
    * 1. Two Sum
    * Given an array of integers "nums" and an integer target,
    * return indices of the two numbers such that they add up to target.
    * You may assume that each input would have exactly one solution,
    * and you may not use the same element twice.
    * You can return the answer in any order.
    *
    * Two loops will create O(N^2)
    * Time Complexity - O(n)
    * Space complexity - O(n)
    * */
    public int[] Q1_TwoSum(int @NotNull [] nums, int target)
    {
        int[] answer = new int[2];
        HashMap<Integer, Integer> visitedMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            if(!visitedMap.containsKey(diff))
            {
                visitedMap.put(nums[i], i);
            }
            else
            {
                answer[0] = i;
                answer[1] = visitedMap.get(diff).intValue();
            }
        }
        return answer;
    }

    /*
     * 11. Container With Most Water
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     * Notice that you may not slant the container.
     */
    public int Q11_MaxArea(int @NotNull [] height)
    {
        int answer = Integer.MIN_VALUE;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < height.length; windowEnd++)
        {
            windowStart = 0;
            while(windowEnd - windowStart > 0)
            {
                int minHeight = Math.abs(Math.min(height[windowEnd], height[windowStart]));
                answer = Math.max(answer, minHeight * Math.abs(windowEnd - windowStart));
                windowStart++;
            }
        }
        return answer;
    }

}
