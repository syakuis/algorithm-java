package com.leetcode.problem;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SearchInsertPosition35Test {
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (target > nums[nums.length - 1]){
            return nums.length;
        }else if (target < nums[0]){
            return 0;
        } else if (target == nums[0]){
            return 0;
        }

        while (left <= right) {
            // 오버플로우 방지를 위해 빼고 더한다.
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return this.binarySearch(nums, target);
    }

    @Test
    void test() {
        int result = this.searchInsert(new int[]{1, 3, 5, 6}, 5);
        log.info("index = {}", result);
    }
}
