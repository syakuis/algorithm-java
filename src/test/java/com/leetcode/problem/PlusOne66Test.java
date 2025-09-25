package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/plus-one/description/
 */
class PlusOne66Test {
    int[] plusOne(int[] digits) {
        int up = 0;
        for (int i = digits.length; i > 0; i--) {
            int now = digits.length == i ? digits[i - 1] + 1 + up : digits[i - 1] + up;
            if (now > 9) {
                up = 1;
                digits[i - 1] = 0;
            } else {
                up = 0;
                digits[i - 1] = now;
            }
        }

        if (up > 0) {
            int[] news = new int[digits.length + 1];
            news[0] = up;
            for (int i = 0; i < digits.length; i++) {
                news[i + 1] = digits[i];
            }

            return news;
        }

        return digits;
    }

    @Test
    void test() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
    }
}

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.


정수 배열 digits로 표현된 큰 정수가 주어지며, 각 digits[i]는 정수의 i번째 자릿수입니다. 자릿수들은 왼쪽에서 오른쪽 순서로 최고 자릿수부터 최저 자릿수까지 정렬되어 있습니다. 큰 정수는 앞자리 0을 포함하지 않습니다. 큰 정수를 1만큼 증가시키고 결과 자릿수 배열을 반환하세요."

예시
예시 1:

입력: digits =

출력:

설명: 배열은 정수 123을 나타냅니다. 1을 더하면 123 + 1 = 124가 되므로 결과는 입니다.

예시 2:

입력: digits =

출력:

설명: 배열은 정수 4321을 나타냅니다. 1을 더하면 4321 + 1 = 4322가 되므로 결과는 입니다.

예시 3:

입력: digits =

출력:

설명: 배열은 정수 9를 나타냅니다. 1을 더하면 9 + 1 = 10이 되므로 결과는 입니다.

제약 조건
1 <= digits.length <= 100

0 <= digits[i] <= 9

digits는 앞자리 0을 포함하지 않습니다

문제 해결 접근법
이 문제는 수학의 덧셈 연산과 올림(carry) 개념을 활용합니다. 배열의 마지막 자릿수부터 시작하여 1을 더하고, 9가 되는 경우 0으로 만들고 다음 자릿수로 올림을 전달합니다. 모든 자릿수가 9인 경우에는 배열 앞에 1을 추가해야 합니다.
*/