package com.ukipoi.leetCode;

import java.util.*;

public class Q95_UniqueBinarySearchTreesII_Ans2 {
    public static void main(String[] args) {
        int n = 10;
        List<TreeNode> treeNodes = generateTrees(n);
        System.out.println(treeNodes.size());
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

//        TreeNode() {
//        }

        TreeNode(int val) {
            this.val = val;
        }

//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
    }

    /**
     * N等于10的时候就体现了差距
     * @param n 一个0到8的整数
     * @return 所有可以生成的二叉树
     */
    private static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
