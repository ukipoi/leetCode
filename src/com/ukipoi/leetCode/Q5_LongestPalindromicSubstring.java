package com.ukipoi.leetCode;

public class Q5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "ac";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }

    //我的方法应该是 中心扩展算法
    public static String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
            int left, right;
            if (s.charAt(i) == s.charAt(i - 1)) {
                left = i - 1;
                right = i;
                while (left >= 0) {
                    left--;
                    right++;
                    if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
                        if (right - left - 2 > max) {
                            max = right - left - 2;
                            start = left + 1;
                            end = right - 1;
                        }
                        break;
                    }
                }
            }
            if (i + 1 < s.length())
                if (s.charAt(i - 1) == s.charAt(i + 1)) {
                    left = i - 1;
                    right = i + 1;
                    while (left >= 0 && right < s.length()) {
                        left--;
                        right++;
                        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
                            if (right - left - 2 > max) {
                                max = right - left - 2;
                                start = left + 1;
                                end = right - 1;
                            }
                            break;
                        }
                    }
                }
        }
        return s.substring(start, end + 1);
    }
}
