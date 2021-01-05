package com.ukipoi.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q830_PositionsOfLargeGroups {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> lists = largeGroupPositions(s);
        System.out.println(lists);
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        boolean flag = false;
        int start = 0, count = 1;
        List<List<Integer>> lists = new ArrayList<>();
        if (s.length() < 3) {
            return lists;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length()) {
                if (flag) {
                    if (count >= 3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(start);
                        list.add(i - 1);
                        lists.add(list);
                    }
                }
                break;
            }
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (!flag) {
                    start = i - 1;
                    flag = true;
                }
                count++;
            } else {
                if (flag) {
                    flag = false;
                    if (count >= 3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(start);
                        list.add(i - 1);
                        lists.add(list);
                    }
                    count = 1;
                }
            }
        }
        return lists;
    }
}
