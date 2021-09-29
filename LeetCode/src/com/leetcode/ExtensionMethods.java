package com.leetcode;

public class ExtensionMethods {

    /**
     * Method to swap elements in the array
     */
    public static void SwapArrayElements(int[] nums, int i, int index)
    {
        if(nums == null || nums.length == 0) return;

        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    /**
     * Method to reverse the array elements
     */
    public static void ReverseArrayElements(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
