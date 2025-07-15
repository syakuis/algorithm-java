package com.leetcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestCommonPrefix14Test {
    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String baseString = strs[0];

        for (int i = 0; i < baseString.length(); i++) {
            for (int x = 1; x < strs.length; x++) {
                if (i >= strs[x].length() || baseString.charAt(i) != strs[x].charAt(i)) {
                    return baseString.substring(0, i);
                }
            }
        }

        return baseString;
    }

    @Test
    void test() {
        assertEquals("fl", longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        assertEquals("", longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
        assertEquals("a", longestCommonPrefix(new String[] { "a" }));
        assertEquals("a", longestCommonPrefix(new String[] { "ab", "a" }));
        assertEquals("c", longestCommonPrefix(new String[] { "cir", "car" }));
    }
}
