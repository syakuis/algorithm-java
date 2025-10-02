package com.leetcode.problem.linkedlist;

import org.junit.jupiter.api.Test;

class MergeTwoSortedLists21 extends AbstractLinkedList {
    ListNode mergerTwoLists(ListNode list1, ListNode list2) {

        int list1Val = list1.val;
        int list2Val = list2.val;

        ListNode aList1 = list1;
        ListNode aList2 = list2;
        ListNode result = new ListNode();

        while (aList1 != null || aList2 != null) {
            if (list1.val < list2.val) {
                result.val = list1.val;
                result.next = list2;
            } else {
                result.val = list2.val;
                result.next = list1;
            }

            aList1 = list1.next;
            aList2 = list2.next;

        }
//
//        if (list1Next != null && list1Next.val < list2Val) {
//            list1Next = new ListNode(list1Next.val, list2);
//        } else {
//            list1Next = list2;
//        }

        if (list1Val < list2Val) {
            return new ListNode(list1Val, list2);
        }

        ListNode list2Next = list2.next;

        if (list2Next != null && list2Next.val < list1Val) {
            list2Next = new ListNode(list2Next.val, list1);
        } else {
            list2Next = list1;
        }

        return new ListNode(list2Val, list2Next);
    }

    @Test
    void testExample1() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode expected = new ListNode(1,
            new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(4,
                            new ListNode(4))))));

        ListNode result = mergerTwoLists(list1, list2);

        assertLinkedListEquals(expected, result);
    }

    @Test
    void testExample2() {
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode expected = null;

        ListNode result = mergerTwoLists(list1, list2);

        assertLinkedListEquals(expected, result);
    }

    @Test
    void testExample3() {
        ListNode list1 = null;
        ListNode list2 = new ListNode(0);
        ListNode expected = new ListNode(0);

        ListNode result = mergerTwoLists(list1, list2);

        assertLinkedListEquals(expected, result);
    }
}