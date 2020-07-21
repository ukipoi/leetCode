package com.ukipoi.leetCode;

import java.util.*;

public class Q95_UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        int n = 9;
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

    private static List<TreeNode> trees;

    /**
     * 感觉自己的想法有问题，缺少从整体到部分的思维。
     * @param n 一个0到8的整数
     * @return 所有可以生成的二叉树
     */
    private static List<TreeNode> generateTrees(int n) {
        trees = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        getAllPer(n,new ArrayList<>(),0);
        Iterator<TreeNode> iterator = trees.iterator();
        while (iterator.hasNext()){
            int temp = set.size();
            List<Integer> list = new ArrayList<>();
            distinct(iterator.next(),list);
            set.add(list);
            if (set.size()==temp){
                iterator.remove();
            }
        }
        return trees;
    }

    private static void distinct(TreeNode treeNode,List<Integer> list){
        list.add(treeNode.val);
        if (treeNode.left!=null){
            distinct(treeNode.left,list);
        }
        if (treeNode.right!=null){
            distinct(treeNode.right,list);
        }
    }

    private static void toTrees(int i, TreeNode tree) {
        if (i > tree.val) {
            if (tree.right == null) {
                tree.right = new TreeNode(i);
            } else {
                toTrees(i, tree.right);
            }
        } else {
            if (tree.left == null) {
                tree.left = new TreeNode(i);
            } else {
                toTrees(i, tree.left);
            }
        }
    }


    private static void getAllPer(int n, List<Integer> list, int index) {
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                if (index == n - 1) {
                    TreeNode treeNode = new TreeNode(list.get(0));
                    for (int index2 = 1; index2 < list.size(); index2++) {
                        toTrees(list.get(index2), treeNode);
                    }
                    trees.add(treeNode);
                    list.remove(index);
                    return;
                }
                getAllPer(n, list, index + 1);
                list.remove(index);
            }
        }
    }
}
