package com.leetcode.problem.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
https://leetcode.com/problems/remove-linked-list-elements/description/
 */
class RemoveLikedListElements203Test {

    ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode current = new ListNode(0);
        ListNode dummy = current;

        while (head != null) {

            if (val != head.val) {
                current.next = new ListNode(head.val);
                current = current.next;
            }

            head = head.next;
        }

        return dummy.next;
    }

    @Test
    void test() {
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode data = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        assertLinkedListEquals(expected, removeElements(data, 6));
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
}
