package com.leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.leetcode.ExtensionMethods.ReverseArrayElements;
import static com.leetcode.ExtensionMethods.SwapArrayElements;

public class Arrays {

    /**
     * 1. Two Sum
     * Given an array of integers "nums" and an integer target,
     * return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     * You can return the answer in any order.
     * Two loops will create O(N^2)
     * Time Complexity - O(n)
     * Space complexity - O(n)
     **/
    public int[] Q1_TwoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> visitedMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (!visitedMap.containsKey(diff)) {
                visitedMap.put(nums[i], i);
            } else {
                answer[0] = i;
                answer[1] = visitedMap.get(diff);
            }
        }
        return answer;
    }

    /**
     * 11. Container With Most Water
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     * Notice that you may not slant the container.
     * Time complexity - O(n)
     * Space Complexity - O(1)
     **/
    public int Q11_MaxAreaSlidingWindowTechnique(int[] height) {
        int answer = Integer.MIN_VALUE;
        int windowStart;
        for (int windowEnd = 0; windowEnd < height.length; windowEnd++) {
            windowStart = 0;
            while (windowEnd - windowStart > 0) {
                int minHeight = Math.abs(Math.min(height[windowEnd], height[windowStart]));
                answer = Math.max(answer, minHeight * Math.abs(windowEnd - windowStart));
                windowStart++;
            }
        }
        return answer;
    }

    /**
     * 11. Container With Most Water
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     * Notice that you may not slant the container.
     * Time complexity - O(n)
     * Space Complexity - O(1)
     **/
    public int Q11_MaxAreaSimpleBoundaries(int[] height) {
        int answer = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd = height.length - 1;
        while (windowStart < windowEnd) {
            answer = Math.max(answer, Math.min(height[windowStart], height[windowEnd]) * (windowEnd - windowStart));
            if (height[windowStart] < height[windowEnd])
                windowStart++;
            else
                windowEnd--;
        }
        return answer;
    }

    /**
     * 15. 3Sum
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     **/
    public List<List<Integer>> Q15_ThreeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) return ans;

        java.util.Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int p = i + 1, q = n - 1;
            while (p < q) {
                if (nums[p] + nums[q] == -nums[i]) {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[p]);
                    t.add(nums[q]);

                    ans.add(t);

                    while (p + 1 < q && nums[p + 1] == nums[p]) p++;
                    while (q - 1 > p && nums[q - 1] == nums[q]) q--;

                    p++;
                    q--;
                } else if (nums[p] + nums[q] < -nums[i]) p++;
                else q--;
            }

            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return ans;
    }

    /**
     * 26. Remove Duplicates from Sorted Array
     **/
    public int Q26_RemoveDuplicates(int[] A) {
        if (A.length < 2)
            return A.length;

        int j = 0;
        int i = 1;
        while (i < A.length) {
            if (A[i] != A[j]) {
                j++;
                A[j] = A[i];
            }
            i++;
        }
        return j + 1;
    }

    /**
     * 31. Next permutation
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order
     * (i.e., sorted in ascending order). The replacement must be in place and use only constant extra memory.
     **/
    public int[] Q31_NextPermutation(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        // Special case if the entire sequence numbers are in decreasing order
        if (k == -1) {
            ReverseArrayElements(nums, 0, nums.length - 1);
            return nums;
        }
        for (int l = nums.length - 1; l > k; --l) {
            if (nums[l] > nums[k]) {
                SwapArrayElements(nums, l, k);
                break;
            }
        }
        ReverseArrayElements(nums, k + 1, nums.length - 1);
        return nums;
    }

    /**
     * 33. Search in Rotated Sorted Array
     * There is an integer array nums sorted in ascending order (with distinct values).
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index
     * k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * You must write an algorithm with O(log n) runtime complexity.
     **/
    public int Q33_Search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int high = nums.length - 1, low = 0;
        int first = nums[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = nums[mid];
            if (value == target) {
                return mid;
            }
            boolean isBig = value >= first;
            boolean isTargetBig = target >= first;
            if (isBig == isTargetBig) {
                if (value < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (isBig) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 34. Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public int[] Q34_SearchRange(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        return null;
    }

    /**
     * 42. Trapping Rain Water
     */
    public int Q42_Trap(int[] height) {
        int rain = 0;
        return rain;
    }

    /**
     * 4. Median of Two Sorted Arrays
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     */
    public double Q4_FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, counter = 0;
        double median = 0;
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int[] nums3 = new int[n1Len + n2Len];
        int newArrLen = n1Len + n2Len;

        while (i < n1Len && j < n2Len) {
            if (nums1[i] < nums2[j]) {
                nums3[counter++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                nums3[counter++] = nums2[j++];
            }
        }
        while (i < n1Len) {
            nums3[counter++] = nums1[i++];
        }
        while (j < n2Len) {
            nums3[counter++] = nums2[j++];
        }

        if (newArrLen % 2 != 0) {
            median = nums3[(int) Math.ceil(newArrLen / 2)];
        } else {
            var midSum = nums3[(newArrLen / 2)] + nums3[(newArrLen / 2) - 1];
            if (midSum == 0) return 0;

            median = (double) midSum / 2;
        }
        return median;
    }

    /**
     * 724. Find Pivot Index
     * Given an array of integers nums, calculate the pivot index of this array.
     * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal
     * to the sum of all the numbers strictly to the index's right.
     * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
     * This also applies to the right edge of the array.
     * Return the leftmost pivot index. If no such index exists, return -1.
     */
    public int Q724_PivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if (total == leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
