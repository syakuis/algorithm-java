package com.leetcode.problem.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
역순으로 계산한 값을 노드 안쪽부터 넣을 수 없다.
계산한 값을 배열에 담고 역순으로 노드를 이동하면서 기록한다.
 */
class AddTwoNumbersII445Test extends AbstractLinkedList {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : -1;
            int num2 = l2 != null ? l2.val : -1;

            if (l1 != null) a1.add(num1);
            if (l2 != null) a2.add(num2);

            l1 = l1 != null && l1.next != null ? l1.next : null;
            l2 = l2 != null && l2.next != null ? l2.next : null;
        }

        int i1 = a1.size() - 1;
        int i2 = a2.size() - 1;
        int carry = 0;

        List<Integer> r = new ArrayList<>();

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // carry 마지막 올림수가 있는 경우 계산하기 위해 조건을 추가한다.
        while (i1 >= 0 || i2 >= 0 || carry != 0) {
            int num1 = i1 >= 0 ? a1.get(i1) : 0;
            int num2 = i2 >= 0 ? a2.get(i2) : 0;

            int sum = num1 + num2 + carry;
            // 올림수를 기록한다.
            carry = sum >= 10 ? 1 : 0;

            // 나머지 값을 구한다.
            r.add(sum % 10);

            i1--;
            i2--;
        }

        System.out.println(r);

        for (int i = r.size() - 1; i >= 0; i--) {
            current.next = new ListNode(r.get(i));
            current = current.next;
        }
        return dummy.next;
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
