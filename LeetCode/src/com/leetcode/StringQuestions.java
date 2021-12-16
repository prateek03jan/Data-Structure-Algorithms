package com.leetcode;

import java.util.HashSet;

public class StringQuestions {

    /**
     * Q3. Longest Substring Without Repeating Characters
     */
    public int Q3_LengthOfLongestSubstring(String s) {
        int length = 0, count = 0;
        var arr = s.toCharArray();
        var sLen = arr.length;
        HashSet<Character> chars = new HashSet<Character>();
        for (int i = 0; i < sLen; i++) {
            for (int j = i; j < sLen; j++) {
                if (!chars.contains(arr[j])) {
                    chars.add(arr[j]);
                    count++;
                    length = Math.max(length, count);
                } else {
                    count = 0;
                    chars.clear();
                    break;
                }
            }
        }
        return length;
    }
}
