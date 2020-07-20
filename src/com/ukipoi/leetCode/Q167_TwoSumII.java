package com.ukipoi.leetCode;

public class Q167_TwoSumII {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(numbers, target));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            int sum = numbers[index1] + numbers[index2];
            if (sum == target) {
                return new int[]{index1 + 1, index2 + 1};
            } else if (sum > target) {
                index2--;
            } else {
                index1++;
            }
        }
        return null;
    }
}
