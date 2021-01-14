package com.ukipoi.leetCode;

public class Q42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        if (height.length < 2) {    //必须有第三根柱子才可能接雨水
            return 0;
        }
        int[] max_h = new int[height.length];   //储存最高柱子的位置
        max_h[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[max_h[i - 1]]) {
                max_h[i] = i;
            } else {
                max_h[i] = max_h[i - 1];
            }
        }
        int[] water = new int[height.length];   //储存雨水量
        water[0] = 0;
        water[1] = 0;
        for (int i = 2; i < height.length; i++) {
            if (height[i] <= height[i - 1]) {   //如果最新的柱子比上一根柱子矮，那必不可能接雨水
                water[i] = water[i - 1];
            } else {
                int j = i - 2;
                while (j >= 0 && height[j] < height[i]) {   //找到第一根比最新柱子高的柱子的位置，必须隔一根开始找
                    j--;
                }
                int wall = 0;
                if (j < 0) {    //如果全都比最新的柱子矮
                    for (int k = max_h[i - 1]; k < i; k++) {    //计算被柱子填充的区块
                        wall += Math.min(height[max_h[i - 1]], height[k]);
                    }
                    water[i] = water[max_h[i - 1]] + (i - max_h[i - 1]) * height[max_h[i - 1]] - wall;  //计算新柱子形成的接水区域
                } else {    //如果有比最新柱子高的
                    for (int k = j; k < i; k++) {
                        wall += Math.min(height[i], height[k]);
                    }
                    water[i] = water[j] + (i - j) * height[i] - wall;
                }
            }
        }
        return water[height.length - 1];
    }
}
