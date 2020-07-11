package com.ukipoi.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Q18_4Sum_Ans2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> ret = new HashSet<>();
        List<Integer> numbers = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
        if (nums.length < 4) {
            return result;
        } else if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                result.add(numbers);
                return result;
            }
        }
        for (int i = 0; i < numbers.size() - 3; i++) {
            int i1 = numbers.get(i) + numbers.get(numbers.size() - 3) + numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1);
            if (target > i1) {
                continue;
            } else if (target == i1) {
                List<Integer> yes = new ArrayList<>();
                yes.add(numbers.get(i));
                yes.add(numbers.get(numbers.size() - 3));
                yes.add(numbers.get(numbers.size() - 2));
                yes.add(numbers.get(numbers.size() - 1));
                ret.add(yes);
            }
            for (int j = i + 1; j < numbers.size() - 2; j++) {
                int i2 = numbers.get(i) + numbers.get(j) + numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1);
                if (target > i2) {
                    continue;
                } else if (target == i2) {
                    List<Integer> yes = new ArrayList<>();
                    yes.add(numbers.get(i));
                    yes.add(numbers.get(j));
                    yes.add(numbers.get(numbers.size() - 2));
                    yes.add(numbers.get(numbers.size() - 1));
                    ret.add(yes);
                }
                //TODO 双指针解题
                int new_target = target - numbers.get(i) - numbers.get(j);
                int sup = j + 1;
                int sub = numbers.size() - 1;
            }
        }
        result.addAll(ret);
        return result;
    }
}
