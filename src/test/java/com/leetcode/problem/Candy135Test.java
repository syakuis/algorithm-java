package com.leetcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Candy135Test {
    int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // 1단계: 모든 아이에게 최소 1개씩 사탕 배정
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // 2단계: 왼쪽에서 오른쪽으로 순회 (왼쪽 이웃과 비교)
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 3단계: 오른쪽에서 왼쪽으로 순회 (오른쪽 이웃과 비교)
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 4단계: 총 사탕 개수 계산
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    @Test
    void test() {
        assertEquals(5, this.candy(new int[]{1, 0, 2}));
        assertEquals(4, this.candy(new int[]{1, 2, 2}));
    }
}
