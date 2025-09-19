package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">leetcode</a>
 */
class FindTheIndexOfTheFirstOccurrenceInAString28Test {
    int strStr(String haystack, String needle) {
        for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
            String text = haystack.substring(i, j);

            System.out.println(text);

            if (Objects.equals(text, needle)) {
                return i;
            }
        }

        return -1;
    }

    @Test
    void test() {
        assertEquals(0, this.strStr("sadbutsad", "sad"));
        assertEquals(-1, this.strStr("leetcode", "leeto"));
        assertEquals(2, this.strStr("hello", "ll"));
    }
}
