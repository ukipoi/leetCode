package com.ukipoi.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q399_EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("c");
        equations.add(strings);
        strings = new ArrayList<>();
        strings.add("b");
        strings.add("e");
        equations.add(strings);
        strings = new ArrayList<>();
        strings.add("c");
        strings.add("d");
        equations.add(strings);
        strings = new ArrayList<>();
        strings.add("e");
        strings.add("d");
        equations.add(strings);
        double[] values = new double[4];
        values[0] = 2d;
        values[1] = 3d;
        values[2] = 0.5d;
        values[3] = 5d;
        List<List<String>> queries = new ArrayList<>();
        strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        queries.add(strings);
        double[] result = calcEquation(equations, values, queries);
        System.out.println(result.length);
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Double> map = new HashMap<>();  //数据的值
        HashMap<String, Integer> conMap = new HashMap<>();  //数据的相关关系
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> strings = equations.get(i);
            String s1 = strings.get(0);
            String s2 = strings.get(1);
            if (map.containsKey(s1) && !map.containsKey(s2)) {
                map.put(s2, map.get(s1) / values[i]);
                conMap.put(s2, conMap.get(s1));
            }
            if (map.containsKey(s2) && !map.containsKey(s1)) {
                map.put(s1, map.get(s2) * values[i]);
                conMap.put(s1, conMap.get(s2));
            }
            if (!map.containsKey(s1) && !map.containsKey(s2)) {
                map.put(s1, 1d);
                map.put(s2, 1d / values[i]);
                conMap.put(s1, i);
                conMap.put(s2, i);
            }
            for (int j = 1; j < equations.size(); j++) {
                List<String> strings1 = equations.get(j);
                String s3 = strings1.get(0);
                String s4 = strings1.get(1);
                if (map.containsKey(s3) && !map.containsKey(s4)) {
                    map.put(s4, map.get(s3) / values[j]);
                    conMap.put(s4, conMap.get(s3));
                }
                if (map.containsKey(s4) && !map.containsKey(s3)) {
                    map.put(s3, map.get(s4) * values[j]);
                    conMap.put(s3, conMap.get(s4));
                }
            }
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> strings = queries.get(i);
            String s1 = strings.get(0);
            String s2 = strings.get(1);
            if (!conMap.containsKey(s1) || !conMap.containsKey(s2)) {   //提问使用的字符不存在
                res[i] = -1d;
            } else if (!conMap.get(s1).equals(conMap.get(s2))) {    //提问使用的字符完全不相关
                res[i] = -1d;
            } else {
                res[i] = map.get(s1) / map.get(s2);
            }
        }
        return res;
    }
}
