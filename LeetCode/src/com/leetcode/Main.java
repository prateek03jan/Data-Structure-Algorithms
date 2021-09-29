package com.leetcode;

public class Main {

    public static void main(String[] args) {
        int[] arr = {6,2,1,5,4,3,0};

        Arrays arrays = new Arrays();
        var test = arrays.Q31_NextPermutation(arr);
        PrintArray(test);
    }

    public static void PrintArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(i + " ");
        }
    }
}
