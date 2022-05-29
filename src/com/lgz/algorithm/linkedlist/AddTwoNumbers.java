package com.lgz.algorithm.linkedlist;

/**
 * leetcode(2): https://leetcode.com/problems/add-two-numbers/
 *
 * @author lgz
 * @ClassName AddTwoNumbers.java
 * @description 两个链表相加
 * @since 2022/05/15 11:18:57
 */
public class AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * 将两个链表相加
         *
         * @param head1
         * @param head2
         * @return
         */
        public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
            int len1 = listLength(head1);
            int len2 = listLength(head2);
            ListNode l = len1 >= len2 ? head1 : head2;
            ListNode s = l == head1 ? head2 : head1;
            ListNode curL = l;
            ListNode curS = s;
            //记录最后一个节点
            //作用：当前两个 while 循环体执行完时，即两个链表相加处理完。这时如果 carry 还为1（代表还要往下进1），就要找到长链表的末节点给它的指针赋值上新节点。
            //     但是两个 while 后，curL 为 null，所以得用 last 保存 curL
            ListNode last = curL;
            //进 1
            int carry = 0;
            int curNum = 0;
            while (curS != null) {
                curNum = curL.val + curS.val + carry;
                curL.val = (curNum % 10);
                carry = curNum / 10;
                last = curL;
                curL = curL.next;
                curS = curS.next;
            }

            while (curL != null) {
                curNum = curL.val + carry;
                curL.val = (curNum % 10);
                carry = curNum / 10;
                last = curL;
                curL = curL.next;
            }
            //如果还有进一还未处理，则在 last 即长链表的末节点后增加个值为 1 的节点。
            if (carry != 0) {
                last.next = new ListNode(1);
            }
            return l;
        }

        /*
         * @param head
         * @return 链表长度
         */
        public static int listLength(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}
