package com.menglong.feihu.algorithm;

import java.util.Arrays;

/**
 * @author lianzeng
 * @version 1.0
 * @date 2020-06-22 : 18:07
 */
public class Solution_16_ThreeNumClosest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                // 判断最小值
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target)) {
                        result = min;
                    }
                    break;
                }
                //判断最大值
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target)) {
                        result = max;
                    }
                    break;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                    // 解决nums[right]重复
                    while (left != right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    // 解决nums[left]重复
                    while (left != right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
            // 解决nums[i]重复
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

}
