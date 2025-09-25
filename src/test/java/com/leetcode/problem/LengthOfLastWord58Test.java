package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLastWord58Test {
    int lengthOfLastWord(String s) {
        int i = s.length();
        int count = 0;

        while(0 < i) {
            char str = s.charAt(i - 1);

            if (str != ' ') {
                count++;
            }

            if (count > 0 && str == ' ') {
                return count;
            }

            i--;
        }

        return count;
    }

    @Test
    void test() {
        assertEquals(5, this.lengthOfLastWord("Hello World"));
        assertEquals(4, this.lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, this.lengthOfLastWord("luffy is still joyboy"));
        assertEquals(1, this.lengthOfLastWord("a"));
        assertEquals(1, this.lengthOfLastWord(" a"));
    }
}

/*
https://leetcode.com/problems/length-of-last-word/description/

Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.


문자열과 공백으로 구성된 문자열 s가 주어졌을 때, 문자열에서 마지막 단어의 길이를 반환하는 문제입니다.

Given a string s consisting of words and spaces, return the length of the last word in the string. A word is a maximal substring consisting of non-space characters only.

"단어와 공백으로 구성된 문자열 s가 주어졌을 때, 문자열에서 마지막 단어의 길이를 반환하세요. 단어는 공백이 아닌 문자들로만 구성된 최대 부분 문자열입니다."

예시
예시 1:

입력: s = "Hello World"

출력: 5

설명: 마지막 단어는 "World"
이고 길이가 5입니다.

예시 2:

입력: s = " fly me to the moon "

출력: 4

설명: 마지막 단어는 "moon"
이고 길이가 4입니다.

예시 3:

입력: s = "luffy is still joyboy"

출력: 6

설명: 마지막 단어는 "joyboy"
이고 길이가 6입니다.

제약 조건
1 <= s.length <= 10⁴

s는 영어 문자와 공백 ' '으로만 구성됩니다

s에는 최소 하나의 단어가 있습니다

문제 해결 접근법
이 문제는 문자열의 끝에서부터 역방향으로 탐색하여 마지막 단어를 찾는 것이 효율적입니다. 먼저 문자열 끝의 공백들을 건너뛰고, 그 다음 공백이 아닌 문자들의 개수를 세면 됩니다.







*/