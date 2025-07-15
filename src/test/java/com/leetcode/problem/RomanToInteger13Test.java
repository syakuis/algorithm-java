package com.leetcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * https://www.perplexity.ai/search/arae-naeyongeul-beonyeoghaejwe-pjk2va_MRWK8Ap.3uBa.AA
 *
 */
@Slf4j
class RomanToInteger13Test {
    private int romanToInt(String s) {
        Map<String, Integer> map = Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int num = map.get(String.valueOf(c));

            int next = i + 1;

            // 현재 값이 다음 값보다 클을 경우
            if (next < s.length()) {
                int nextNum = map.get(String.valueOf(s.charAt(next)));

                if (nextNum > num) {
                    result = result - num;
                } else {
                    result = result + num;
                }
            } else {
                result = result + num;
            }

        }

        log.info("result {}", result);

        return result;
    }

    @Test
    void test() {
        assertEquals(3, this.romanToInt("III"));
        assertEquals(58, this.romanToInt("LVIII"));
        assertEquals(1994, this.romanToInt("MCMXCIV"));
    }
}
