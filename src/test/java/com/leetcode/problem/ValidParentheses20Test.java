package com.leetcode.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

class ValidParentheses20Test {
    boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c)
                        return false;
            }
        }

        return stack.isEmpty();
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
        assertTrue(isValid("(([]){})"));
        assertFalse(isValid("(){}}{"));
    }
}
