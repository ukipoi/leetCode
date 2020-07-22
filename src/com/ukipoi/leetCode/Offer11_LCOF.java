package com.ukipoi.leetCode;

public class Offer11_LCOF {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 3, 1, 3};
        System.out.println(minArray(numbers));
    }

    private static int minArray(int[] numbers) {
        int i = 1;
        int j = numbers.length - 1;
        int temp_i = numbers[0];
        int temp_j = numbers[j];
        while (i <= j) {
            if (i == j) {
                temp_i = Math.min(numbers[i], temp_i);
                break;
            }
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
            if (numbers[j] < numbers[j - 1]) {
                return numbers[j];
            }
            temp_i = Math.min(numbers[i], temp_i);
            temp_j = Math.min(numbers[j], temp_j);
            i++;
            j--;
        }
        return Math.min(temp_i, temp_j);
    }
}
