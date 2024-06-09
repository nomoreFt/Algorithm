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
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null) slow = slow.next;
      
        ListNode tail = reverseListNode(slow);

        return checkTwoListNodePalindrome(head, tail);
}

public ListNode reverseListNode(ListNode target){
    ListNode tail = null;
    ListNode current = target;
    
    while(current != null){
        ListNode temp = current.next;
        current.next = tail;
        tail = current;
        current = temp;
    }
    return tail;
}

public boolean checkTwoListNodePalindrome(ListNode head, ListNode tail){
    while(tail != null){
        if(head.val != tail.val) return false;
        head = head.next;
        tail = tail.next;
    }
    return true;
}
}