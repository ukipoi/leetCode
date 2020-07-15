package com.ukipoi.leetCode;

public class Q96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(numTrees(n));
    }

    /**
     * 这题我没解出来，看到题目的第一个想法是要找出所有的排序方式，期间想到过循环1到N的数值作为开头，然后把所有的排列方式列出来
     * 不过想法想偏了，往具体的排列想了，其实不需要具体，因为给定的数组是连续大于零的自然数，所以只要确定了第一个节点，然后分成左子树和右子树的情况递归就行了
     * 思考的中途也感觉到了有数学解法，因为N个数的排列是固定的N!，然后剩下的是去除重复的情况。但是最后也没想出来解法，自己的数学能力和见识还是太肤浅了
     * 最终的结果是把所有的排序情况的了出来，但是在帅选重复值的时候放弃了。因为想到自己最后的解法是把所有的结果经过二叉树排序在输出，感觉效率低下，肯定不是应有的答案
     * @param n 大于1的整数
     * @return 所有的二叉排序树数目
     */
    private static int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0]=1;
        nums[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                nums[i]+=nums[j-1]*nums[i-j];
            }
        }
        return nums[n];
    }
}
