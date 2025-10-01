package com.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
class RemoveDuplicatesFromSortedList83Test {
    ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode nHead = new ListNode();
        ListNode nTarget = new ListNode(head.val);
        nHead.next = nTarget;

        int x = head.val;

        while (head != null) {
            System.out.println(head.val);
            if (x != head.val) {
                System.out.println("생성");
                x = head.val;
                ListNode a = nTarget;
                a.next = new ListNode(x);
                nTarget = a.next;
            }

            head = head.next;
        }

        return nHead.next;
    }

    @Test
    void test() {
        ListNode expected = new ListNode(1, new ListNode(2));
        ListNode data = new ListNode(1, new ListNode(1, new ListNode(2)));
        assertLinkedListEquals(expected, deleteDuplicates(data));
    }

    @Test
    void test2() {
        ListNode expected2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode data2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        assertLinkedListEquals(expected2, deleteDuplicates(data2));
    }

    @Test
    void test3() {
        ListNode expected = new ListNode(1);
        ListNode data = new ListNode(1, new ListNode(1));
        assertLinkedListEquals(expected, deleteDuplicates(data));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private void assertLinkedListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(expected);
        assertNull(actual);
    }
}

/*
Given the of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.head



Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]


Constraints:

The number of nodes in the list is in the range .[0, 300]
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.


문제 설명
정렬된 연결 리스트의 헤드가 주어지면, 중복되는 것들을 지워서 각 원소들이 한 번씩만 나타나게 하고 연결 리스트를 정렬된 상태로 반환해야 합니다.

예시
예시 1:

입력: head =

출력: ``

예시 2:

입력: head =

출력: ``

제약 조건
리스트의 노드 개수 범위:

노드 값 범위: -100 ≤ Node.val ≤ 100

리스트는 오름차순으로 정렬되어 있음이 보장됩니다

 */