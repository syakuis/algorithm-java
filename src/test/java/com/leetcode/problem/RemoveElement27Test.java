package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveElement27Test {
    int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

    @Test
    void test() {
        assertEquals(2, removeElement(new int[]{3,2,2,3}, 3));
        assertEquals(1, removeElement(new int[]{3,3,2,3}, 3));
        assertEquals(5, removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
