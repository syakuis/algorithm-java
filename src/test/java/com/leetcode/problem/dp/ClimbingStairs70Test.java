package com.leetcode.problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/climbing-stairs/description/

풀이 힌트
이 문제는 **동적 계획법(Dynamic Programming)**의 대표적인 예시입니다. n번째 계단에 도달하는 방법은 (n-1)번째 계단에서 1계단 오르거나, (n-2)번째 계단에서 2계단 오르는 두 가지 경우의 합입니다. 이는 피보나치 수열과 동일한 점화식을 가집니다.

기저 조건을 설정하고 작은 값부터 차례대로 계산해 나가는 bottom-up 방식을 사용하면 효율적으로 해결할 수 있습니다.

0층
│
├─ 1층 (1칸)
│   ├─ 2층 (1+1)
│   │   ├─ 3층 (1+1+1)
│   │   │   └─ 4층 (1+1+1+1)
│   │   └─ 4층 (1+1+2)
│   └─ 3층 (1+2)
│       └─ 4층 (1+2+1)
└─ 2층 (2칸)
    ├─ 3층 (2+1)
    │   └─ 4층 (2+1+1)
    └─ 4층 (2+2)
*/
class ClimbingStairs70Test {
    // n = 1보다 크거나 같고 45보다 작거나 같다.
    int climbStairs(int n) {

        int[] dp = new int[n + 1];
        // 점화식 계산을 위해 0과 1은 1로 초기화한다.
        dp[0] = 1;
        dp[1] = 1;

        // 2층부터 시작하여 n층 까지 반복한다.
        for (int i = 2; i <= n; i++) {
            // 점화식으로 이전에 계산한 값을 더해서 현재 층을 구한다.
            // 1계단을 오르거(-1)나 2계단을 오를수 있는(-2) 조건으로 구한다.
            // 현재층 방법 수 = 현재 한칸 아래층 방법 수 + 현재 두칸 아래층 방법 수
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    @Test
    void test() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }
}

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45

계단 오르기 문제
당신은 계단을 오르고 있습니다. 꼭대기에 도달하려면 n개의 계단을 올라야 합니다.

매번 1개 또는 2개의 계단을 오를 수 있습니다. 꼭대기까지 오를 수 있는 서로 다른 방법은 몇 가지입니까?

예시 1:
입력: n = 2

출력: 2

설명: 꼭대기까지 오르는 방법은 두 가지입니다.

1계단 + 1계단

2계단

예시 2:
입력: n = 3

출력: 3

설명: 꼭대기까지 오르는 방법은 세 가지입니다.

1계단 + 1계단 + 1계단

1계단 + 2계단

2계단 + 1계단

제약조건:
1 ≤ n ≤ 45
 */