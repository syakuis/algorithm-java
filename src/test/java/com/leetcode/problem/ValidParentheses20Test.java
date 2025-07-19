package com.leetcode.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class ValidParentheses20Test {
    boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> store = new Stack<>();
        List<Character> open = List.of('(', '{', '[');
        List<Character> close = List.of(')', '}', ']');

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            int opened = open.indexOf(item);

            if (i == 0 && opened == -1) {
                return false;
            }

            if (opened > -1) {
                store.push(item);
            } else {
                if (store.isEmpty()) return false;

                char openedBracket = store.pop();
                char closedBracket = close.get(open.indexOf(openedBracket));

                if (closedBracket != item) {
                    return false;
                }
            }
        }

        return store.isEmpty();
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
