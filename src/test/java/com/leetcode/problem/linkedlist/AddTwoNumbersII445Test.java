package com.leetcode.problem.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/*
[요약]
두 연결 리스트로 표현된 수를 더한다.

7 > 2 > 4 > 3
    5 > 6 > 4
7   8   0   7

0 <= Node.val <= 9

[풀이]
가장 낮은 자릿수부터 계산한다.
재귀함수를 사용하면 마지막 노드부터 처리할 수 있다. 하지만 길이가 다른 두 노드는 마지막 노드가 없을 수 있다.
각 연결 리스트의 값을 배열에 저장하고 역순으로 계산한다. 합이 10이상인 경우 올림을 하기위해 역순으로 처리한다.
역순으로 계산한 값을 노드 안쪽부터 역순으로 처리한다.
 */
class AddTwoNumbersII445Test extends AbstractLinkedList {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // stack(LIFO) 으로 역순으로 꺼내온다. 동기화때문에 느리다.
        // deque(LIFO, FIFO) 로 동기화가 없는 구현체 사용. 스택과 큐(FIFO) 모두 사용할 수있다.
        Deque<Integer> a1 = new ArrayDeque<>();
        Deque<Integer> a2 = new ArrayDeque<>();

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : -1;
            int num2 = l2 != null ? l2.val : -1;

            if (l1 != null) a1.push(num1);
            if (l2 != null) a2.push(num2);

            l1 = l1 != null && l1.next != null ? l1.next : null;
            l2 = l2 != null && l2.next != null ? l2.next : null;
        }

        int carry = 0;
        ListNode result = null;

        // carry 마지막 올림수가 있는 경우 계산하기 위해 조건을 추가한다.
        while (!a1.isEmpty() || !a2.isEmpty() || carry != 0) {
            int num1 = a1.isEmpty() ? 0 : a1.pop();
            int num2 = a2.isEmpty() ? 0 : a2.pop();

            int sum = num1 + num2 + carry;
            // 올림수를 기록한다.
            carry = sum / 10;

            // 나머지 값을 구한다.
            ListNode n = new ListNode(sum % 10);
            n.next = result;
            result = n;
        }

        return result;
    }

    @Test
    void test() {
        assertLinkedListEquals(listNodeOf(7, 8, 0, 7), addTwoNumbers(
            listNodeOf(7, 2, 4, 3),
            listNodeOf(5, 6, 4)
        ));
    }

    @Test
    void test2() {
        assertLinkedListEquals(listNodeOf(1, 0), addTwoNumbers(
            listNodeOf(5),
            listNodeOf(5)
        ));
    }
}
