package com.leetcode.problem.linkedlist;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
class RemoveDuplicatesFromSortedList83Test extends AbstractLinkedList {
    ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 더미에 노드를 백업하여 노드가 이동되지 않게 시작 포인터를 유지한다.
        ListNode dummy = head;

        while (head != null && head.next != null) {
            // 현재 노드와 다음 노드 값이 같으면
            if (head.val == head.next.val) {
                // 다음 노드를 다음 다음 노드로 대체하고 중복된 노드를 제거한다
                head.next = head.next.next;
            } else {
                // 다음 노드로 이동한다.
                head = head.next;
            }
        }

        return dummy;
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