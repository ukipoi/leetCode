package com.ukipoi.leetCode;

public class Q70_ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        int i = climbStairs(n);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        int[] x = new int[n+1];
        x[1]=1;
        x[2]=2;
        for (int i=3;i<=n;i++){
            x[i]=x[i-1]+x[i-2];
        }
        return x[n];
    }
}
