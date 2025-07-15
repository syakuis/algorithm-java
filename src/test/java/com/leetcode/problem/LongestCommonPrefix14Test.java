package com.leetcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestCommonPrefix14Test {
    private String longestCommonPrefix(String[] strs) {
        String result = "";

        if (strs.length <= 1) {
            return strs[0];
        }

        String baseString = strs[0];

        for (int i = 0; i < baseString.length(); i++) {
            int success = 1;

            for (int x = 1; x < strs.length; x++) {
                String target = strs[x];
                if (i >= target.length() || baseString.charAt(i) != target.charAt(i)) {
                    success = 0;
                    break;
                }
            }

            if (success == 1) {
                result += baseString.charAt(i);
            } else {
                break;
            }
        }

        return result;
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
