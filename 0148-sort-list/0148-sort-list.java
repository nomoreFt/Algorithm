/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.next = next; this.val = val; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: 리스트가 비어있거나, 원소가 하나라면 정렬이 필요 없음
        if (head == null || head.next == null) return head;

        // 중간점 찾기 (Slow & Fast Pointer)
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // 리스트를 두 개로 나누기

        // 재귀적으로 정렬
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 병합
        return mergeTwoLists(l1, l2);
    }

    // 두 정렬된 리스트를 병합
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 남은 노드를 연결
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
