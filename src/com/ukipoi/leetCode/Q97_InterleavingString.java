package com.ukipoi.leetCode;


public class Q97_InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    /**
     * 没有使用动态规划，做了很多重复运算，导致花的时间很长。
     * 具体可以看动态规划和递归的差距 https://zhuanlan.zhihu.com/p/87179070
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @param s3 组合字符串
     * @return s3是否由s1和s2组合而成
     */
    private static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }
        return a(s1, s2, s3, 0, 0);
    }

    private static boolean a(String s1, String s2, String s3, int index_s1, int index_s2) {
        if (index_s1 == 0 && index_s2 == 0) {
            if (!s1.isEmpty())
                if (s3.charAt(0) == s1.charAt(0)) {
                    if (a(s1, s2, s3, 1, 0)) {
                        return true;
                    }
                }
            if (!s2.isEmpty())
                if (s3.charAt(0) == s2.charAt(0)) {
                    if (a(s1, s2, s3, 0, 1)) {
                        return true;
                    }
                }
        } else {
            if (index_s1 < s1.length() && s3.charAt(index_s1 + index_s2) == s1.charAt(index_s1)) {
                if (a(s1, s2, s3, index_s1 + 1, index_s2)) {
                    return true;
                }
            }
            if (index_s2 < s2.length() && s3.charAt(index_s1 + index_s2) == s2.charAt(index_s2)) {
                return a(s1, s2, s3, index_s1, index_s2 + 1);
            }
        }
        return s1.length() == index_s1 && s2.length() == index_s2;
    }
}
