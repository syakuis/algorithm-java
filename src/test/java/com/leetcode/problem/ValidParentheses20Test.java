package com.leetcode.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ValidParentheses20Test {
    boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        List<Character> opened = List.of('(', '{', '[');
        List<Character> closed = List.of(')', '}', ']');

        for (int i = 0, x = s.length() - 1; i < s.length(); i++, x--) {
            char left = s.charAt(i);
            int index = opened.indexOf(left);
            if (i == 0 && index == -1) {
                return false;
            }
            if (index == -1) {
                continue;
            }

            char closedBracket = closed.get(index);

            char right = x > i ? s.charAt(x) : '\0';
            char leftNext = s.length() > (i + 1) ? s.charAt(i + 1) : '\0';

            if ((leftNext != '\0' && closedBracket == leftNext) || ( right != '\0'  && closedBracket == right)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertTrue(isValid("([])"));
        assertFalse(isValid("(]"));
        assertFalse(isValid("(}{)"));
        assertFalse(isValid("(])"));
        assertFalse(isValid("([}}])"));
    }
}
