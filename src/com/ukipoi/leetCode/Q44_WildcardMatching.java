package com.ukipoi.leetCode;

public class Q44_WildcardMatching {
    public static void main(String[] args) {
        String s = "ac";
        String p = "ab*";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    /**
     * 明明在练习动态规划，知道可以用动态规划解题，但是还是写成了暴力法
     * @param s 被匹配的字符串
     * @param p 匹配的字符串
     * @return 是否可以匹配
     */
    public static boolean isMatch(String s, String p) {
        if ("".equals(p)) {
            return s.equals("");
        }
        int[][] match = new int[p.length()][2]; //[0]表示上个字符匹配的位置，[1]表示上个*匹配的位置；
        //其实可以只用几个int变量就行，因为只需要记录最新的'*'字符的位置，以及'*'字符匹配s字符串的位置就可以了
        match[0][1] = -1;   //-1表示目前没有遇到过‘*’的字符
        if (p.charAt(0) == '*') {
            match[0][0] = -1;
            match[0][1] = 0;
        } else if (s.length() > 0 && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))) {
            match[0][0] = 0;
        } else {
            return false;
        }
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                match[i][0] = match[i - 1][0];  //因为‘*’可以匹配空字符串，所以不推动s字符串的进行
                match[i][1] = i;    //更新最新的‘*’字符的位置
            } else {
                match[i][1] = match[i - 1][1];  //不管怎样，i位置肯定不是*字符，先做更新
                if (match[i - 1][0] + 1 >= s.length()) {    //如果超出了被匹配字符串的长度，那肯定就无法匹配了
                    return false;
                }
                if (p.charAt(i) == s.charAt(match[i - 1][0] + 1) || p.charAt(i) == '?') {   //如果可以匹配
                    if (match[i][1] != -1 && i == p.length() - 1 && match[i - 1][0] + 1 < s.length() - 1) { //匹配的字符串到了结尾，但是被匹配字符串还没有匹配完
                        i = match[i][1];
                        match[i][0] = match[i][0] + 1;
                    } else {
                        match[i][0] = match[i - 1][0] + 1;
                    }
                } else if (match[i][1] != -1) { //不能匹配但是前面存在'*'
                    i = match[i][1];    //退到上一次匹配'*'字符的位置
                    match[i][0] = match[i][0] + 1;  //把'*'字符匹配推进一位
                } else {    //不能匹配但是不存在'*'
                    return false;
                }
            }
        }
        if (p.charAt(p.length() - 1) != '*') {
            return match[p.length() - 1][0] == s.length() - 1;
        }
        return true;
    }
}
