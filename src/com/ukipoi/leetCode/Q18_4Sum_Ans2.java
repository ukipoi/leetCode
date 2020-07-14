package com.ukipoi.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Q18_4Sum_Ans2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
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
            }
            for (int j = i + 1; j < numbers.size() - 2; j++) {
                int i2 = numbers.get(i) + numbers.get(j) + numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 1);
                if (target > i2) {
                    continue;
                }
                //TODO 双指针解题
                int new_target = target - numbers.get(i) - numbers.get(j);
                int sup = j + 1;
                int sub = numbers.size() - 1;
                while (sup < sub) {
                    if (new_target > numbers.get(sup) + numbers.get(sub)) {
                        sup++;
                    } else if (new_target < numbers.get(sup) + numbers.get(sub)) {
                        sub--;
                    } else {
                        List<Integer> yes = new ArrayList<>();
                        yes.add(numbers.get(i));
                        yes.add(numbers.get(j));
                        yes.add(numbers.get(sub));
                        yes.add(numbers.get(sup));
                        ret.add(yes);
                        while (sup < sub && numbers.get(sup) == numbers.get(sup + 1)) {
                            sup++;
                        }
                        while (sup < sub && numbers.get(sub) == numbers.get(sub - 1)) {
                            sub--;
                        }
                        sup++;
                        sub--;
                    }
                }
            }
        }
        result.addAll(ret);
        return result;
    }
}
