package com.ukipoi.leetCode;

public class Q10_RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    /**
     * '.'可以匹配任何字符，‘*’是匹配前一个字符N次（N>=0）
     * 主要看match[i,j]是否可以从match[i-n,j-m]推导出来，
     * 答案是可以的，所以只需要找出有几种可能就可以
     * @param s 被匹配的字符串
     * @param p 匹配的字符串
     * @return 是否可以匹配
     */
    public static boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];    //因为0表示空字符，而不是第一个字符，所以数组长度要为length+1
        match[0][0] = true; //表示两个空字符匹配时的状态
        for (int i = 1; 2 * i <= p.length(); i++) { //先确定s为空字符使的匹配状态
            if (p.charAt(2 * i - 1) == '*') {
                match[0][2 * i] = true;
            } else {
                break;  //只要有一个不能满足要求，那后面的都不能满足要求了。直接break
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {   //因为j表示第N个字符，所以要取第j个字符得用p[j-1]
                    match[i][j] = match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                } else {
                    match[i][j] = j > 1 && (match[i][j - 2] //如果p[j-1]是‘*’，我们可以不使用这次匹配，也就是j-2的时候就匹配完了s[0-i]的字符，那只要match[i][j-2]是true就可以了
                            || (match[i - 1][j - 2] || match[i - 1][j]) //这里有两种情况，就是上一个字符是否是使用'*'状态匹配的
                            && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
