package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArray26Test {

    // 느린과 빠른을 한칸식 이동하면서 고유한 값을 찾아 배열을 재정렬하면서 탐색한다.
    int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        // 첫번째 값은 고유하므로 1로 시작
        int result = 1;

        int slow = 0, fast = 1;
        while (fast < nums.length) {
            // 값이 다르면 재정렬과 이동
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
                result++;
                fast++;
                // 같으면 빠른만 이동
            } else {
                fast++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return result;
    }

    @Test
    void testa() {
        assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
        assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}