package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/sqrtx/description/
 * <p>
 * 이진검색 사용, 같으면 종료, 시퀀스가 작으면 +1 현재값 지정, 크면 -1
 * 긴 숫자 처리를 위해 long 타입 사용
 * 제곱근을 구할 때는 0부터 목표 숫자까지의 범위에서 제곱했을 때 목표값과 같거나 가장 가까운 값을 찾는 다.
 */
class Sqrtx69Test {
    int mySqrt(int x) {
        int result = 0;
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long seq = (long) mid * mid;

            if (seq == x) {
                return mid;
            } else if (seq < x) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    @Test
    void test() {
        assertEquals(2, mySqrt(4));
        assertEquals(2, mySqrt(8));
        assertEquals(46339, mySqrt(2147395599));
    }
}

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.


Constraints:

0 <= x <= 231 - 1

음이 아닌 정수 x가 주어졌을 때, x의 제곱근을 가장 가까운 정수로 내림하여 반환하는 문제입니다. 반환되는 정수 또한 음이 아니어야 합니다.

내장된 지수 함수나 연산자를 사용해서는 안 됩니다. 예를 들어, C++에서 pow(x, 0.5)나 Python에서 x ** 0.5를 사용하면 안 됩니다.

예시 설명
예시 1:

입력: x = 4

출력: 2

설명: 4의 제곱근은 2이므로 2를 반환합니다.

예시 2:

입력: x = 8

출력: 2

설명: 8의 제곱근은 2.82842...이고, 가장 가까운 정수로 내림하면 2가 반환됩니다.

제약 조건
0 <= x <= 2³¹ - 1

문제 해결 접근법
이 문제는 이진 탐색을 사용하여 효율적으로 해결할 수 있습니다. 0부터 x까지의 범위에서 제곱했을 때 x보다 작거나 같은 가장 큰 수를 찾으면 됩니다.

탐색 범위를 설정하고, 중간값의 제곱이 목표값 x와 비교하여 범위를 좁혀나가는 방식으로 접근합니다. 중간값의 제곱이 x보다 작거나 같으면 더 큰 값을 찾아보고, 크면 더 작은 값을 탐색합니다.

시간 복잡도는 O(log x)이며, 공간 복잡도는 O(1)입니다
 */
