/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 0; i < left-1; i++){
            prev = prev.next;//변경 left 바로 직전 Node
        }

       ListNode curr = prev.next;
        ListNode target = curr.next;

        // 노드들을 역순으로 변환
        for (int i = 0; i < right - left; i++) {
            curr.next = target.next;
            target.next = prev.next;
            prev.next = target;
            target = curr.next;
        }
        


        
        return dummy.next;
    }
}