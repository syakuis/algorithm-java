package com.leetcode.problem.linkedlist;

import org.junit.jupiter.api.Test;

/*
https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description

매개변수 숫자형 배열의 값이 노드에 존재하면 제거하고 노드를 반환한다.
일치한 값이 없으면 노드를 그대로 반환한다.

헤드 노드의 첫 노드를 제거할 수 없으므로 더미 노드를 만들어 사용한다.
제거할 배열 숫자를 조회하기 쉽게 변경한다.
제거할 배열 숫자와 일치하지 않는 숫자만 노드로 기록한다.

 */
class DeleteNodesFromLinkedListPresentInArray3217Test extends AbstractLinkedList {
    ListNode modifiedList(int[] nums, ListNode head) {

        int max = -1;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        // 맵 보다 배열이 빠르다. 직접적으로 메모리에 접근하므로 배열이 빠르다.
        boolean[] store = new boolean[max + 1];

        for (int num : nums) {
            store[num] = true;
        }


        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (head != null) {
            if (!store[head.val]) {
                current.next = new ListNode(head.val);
                current = current.next;
            }

            head = head.next;
        }


        return dummy.next;
    }

    @Test
    void test() {
        ListNode data = modifiedList(
            new int[]{1, 2, 3},
            listNodeOf(1, 2, 3, 4, 5));

        println(data);

        assertLinkedListEquals(
            listNodeOf(4, 5),
            data);
    }

    @Test
    void test2() {
        ListNode data = modifiedList(
            new int[]{1},
            listNodeOf(1, 2, 1, 2, 1, 2));

        assertLinkedListEquals(
            listNodeOf(2, 2, 2),
            data);
    }
}
