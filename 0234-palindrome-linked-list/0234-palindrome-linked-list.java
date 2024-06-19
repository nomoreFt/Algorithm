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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast != null){
            slow = slow.next;
        }

        ListNode reverse = null;
        
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = temp;
        }

        while(reverse != null){
            if(head.val != reverse.val) return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}