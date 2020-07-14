package com.ukipoi.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q120_Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.stream(new int[]{2}).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(new int[]{3, 4}).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(new int[]{6, 5, 7}).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(new int[]{4, 1, 8, 3}).boxed().collect(Collectors.toList()));
        System.out.println(minimumTotal(triangle));
    }

    /**
     * 查找三角形从顶部到底部的最短路径。稍微比较了下全部遍历和记录下每一层的值，
     * 感觉还是记录下每层的值，继续算下一层更加方便，毕竟省去了重新算上层三角的步骤
     * @param triangle 三角形
     * @return 最短路径的值
     */
    private static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int size = triangle.size();
        int[][] tempPath = new int[size][size];
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0) {
                    tempPath[i][j] = triangle.get(i).get(j);
                } else if (j == 0) {
                    tempPath[i][j] = tempPath[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    tempPath[i][j] = tempPath[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    tempPath[i][j] = Math.min(tempPath[i - 1][j], tempPath[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            minPath = Math.min(tempPath[size - 1][i], minPath);
        }
        return minPath;
    }
}
