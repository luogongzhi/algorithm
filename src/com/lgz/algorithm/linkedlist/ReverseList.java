package com.lgz.algorithm.linkedlist;

/**
 * @author lgz
 * @ClassName ReverseList.java
 * @description 链表反转
 * @since 2022/04/23 22:23:29
 */
public class ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node (int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 单链表反转
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 单链表反转
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1 = reverseList(n1);
        while (n1 != null) {
            System.out.print(n1.value + " ");
            n1 = n1.next;
        }
    }
}
