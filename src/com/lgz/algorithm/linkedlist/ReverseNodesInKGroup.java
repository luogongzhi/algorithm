package com.lgz.algorithm.linkedlist;

/**
 * leetcode(25) https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author lgz
 * @ClassName ReverseNodesInKGroup.java
 * @description k个节点的组内逆序调整
 * @since 2022/04/24 22:29:27
 */
public class ReverseNodesInKGroup {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    /**
     * 思路1：找到以 start 开始的 第 k 个节点（即组内最后一个节点）。
     *       如果该组不满 k 个节点，则返回最后一个不为 null 的节点。
     * @param start 开始节点
     * @param k 组内节点数
     * @return 组内最后节点
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    /**
     * 思路2：将 start 至 end 的组内节点指向反转
     * @param start 开始反转的节点
     * @param end 最后反转的节点
     */
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //反转后的最末节点指向最末节点的下一个节点
        start.next = end;
    }

    /**
     * 思路3：先将第一组凑齐并完成反转。没凑齐就直接结束。然后将第一组的最后节点拿到，如果这个节点后面有节点就一样把组凑齐，然后反转
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        //第一组筹齐
        head = end;
        reverse(start, end);
        //上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }
}
