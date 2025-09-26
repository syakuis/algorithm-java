package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/add-binary/description/
 */
class AddBinary67Test {
    String addBinary(String a, String b) {
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int x = a.length() - 1, y = b.length() - 1;

        while (x >= 0 || y >= 0 || carry == 1) {
            int aa = x >= 0 ? a.charAt(x--) - '0' : 0;
            int bb = y >= 0 ? b.charAt(y--) - '0' : 0;

            int sum = aa + bb + carry;

            if (sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }

            sb.insert(0, sum % 2);
        }

        return sb.toString();
    }

    @Test
    void test() {
        assertEquals("100", addBinary("11", "1"));
        assertEquals("11110", addBinary("1111", "1111"));
    }
}

/*
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

"두 이진수 문자열 a와 b가 주어졌을 때, 그들의 합을 이진수 문자열로 반환하세요."

예시
예시 1:

입력: a = "11", b = "1"

출력: "100"

예시 2:

입력: a = "1010", b = "1011"

출력: "10101"

제약 조건
1 <= a.length, b.length <= 10⁴

a와 b는 '0' 또는 '1' 문자로만 구성됩니다

각 문자열은 자기 자신을 제외하고 앞자리 0을 포함하지 않습니다

문제 해결 접근법
이 문제는 이진수 덧셈의 기본 원리를 이해하고 직접 구현하는 것이 핵심입니다.

핵심 이진수 덧셈 규칙:

0 + 0 = 0

0 + 1 = 1

1 + 0 = 1

1 + 1 = 10 (올림 발생)

1 + 1 + 1 = 11 (이전 올림까지 포함)

알고리즘 단계:

두 문자열을 오른쪽부터 왼쪽으로 순회하며 각 자리별 덧셈 수행

각 자리에서 두 비트와 이전 자리의 올림을 더함

합이 2 이상이면 올림 발생, 현재 자리는 합을 2로 나눈 나머지

결과를 문자열로 구성하고 마지막 올림도 처리

이 문제는 수동으로 이진수 덧셈 로직을 구현하여 해결해야 하며, 내장 함수 사용 없이 순수한 알고리즘만으로 풀어야 합니다.
*/
