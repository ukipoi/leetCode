package com.ukipoi.leetCode;

public class Q35_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }

    /**
     * 没有留意到题目的tag，需要二分法来解决问题。
     * 我看到需要返回位置，就使用了顺序查找
     * @param nums 有序数组
     * @param target 目标值
     * @return 返回目标值的位置或者要插入的位置
     */
    private static int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            if (target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}
