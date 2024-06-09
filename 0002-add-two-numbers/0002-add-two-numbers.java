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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(-1);
      ListNode result = head;
      
      int sum = 0;
      int carry = 0;
      int remainer = 0;
      
      while(l1 != null || l2 != null || carry != 0){
        sum = 0;
        
        if(l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }
        
        if(l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }
        
        remainer = (sum + carry) % 10;
        carry = (sum + carry) / 10;
        result.next = new ListNode(remainer);
        result = result.next;
      }

      return head.next;

    }
}