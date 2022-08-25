package com.anunay.recursion.linkedlist;

public class ReverseLinkedList {
    private static ListNode head = new ListNode(1,
                                    new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5, null)))));

    public static void main(String[] args) {
        ListNode reverse = reverseList(head);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        // Base condition: return last node
        if (head == null || head.next == null) return head;
        // Call reverse on rest of the list
        ListNode rest = reverseList(head.next);
        // Create link in reverse direction e.g 2->1
        head.next.next = head;
        // Tricky part: Don't forget to break the current link! e.g 1->2
        head.next = null;
        // Adjust the head
        return rest;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
