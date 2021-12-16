package com.leetcode;

public class Main {

    public static void main(String[] args) {
        int[] arr = {6, 2, 1, 5, 4, 3, 0};

        Arrays arrays = new Arrays();
        StringQuestions stringQuestions = new StringQuestions();
        int[] arr1 = new int[2];
        arr1[0] = 0;
        arr1[1] = 0;
        int[] arr2 = new int[2];
        arr2[0] = 0;
        arr2[1] = 0;
//        Print(stringQuestions.Q3_LengthOfLongestSubstring("pwwkew"));
//        var test = arrays.Q31_NextPermutation(arr);
//        PrintArray(test);
        Print(arrays.Q4_FindMedianSortedArrays(arr1, arr2));
    }

    public static void Print(Object obj) {
        System.out.println(obj);
    }

    public static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " ");
        }
    }
}
