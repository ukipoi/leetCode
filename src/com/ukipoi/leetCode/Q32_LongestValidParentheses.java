package com.ukipoi.leetCode;

public class Q32_LongestValidParentheses {
    public static void main(String[] args) {
        String s = "())()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }

    public static int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int max = 0;
        int[] nums = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i < 2) {
                        nums[i] = 2;
                    } else {
                        nums[i] = nums[i - 2] + 2;
                    }
                } else {
                    if (i - nums[i - 1] - 1 >= 0 && s.charAt(i - nums[i - 1] - 1) == '(') {
                        if (i - nums[i - 1] - 2 < 0) {
                            nums[i] = nums[i - 1] + 2;
                        } else {
                            nums[i] = nums[i - nums[i - 1] - 2] + nums[i - 1] + 2;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
