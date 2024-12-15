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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while(cur != null){
            ListNode path = cur.next;//cur를 삽입시켜 없애야 해서 미리 next받아놓음
            ListNode temp = dummy; //맨 앞으로 초기화

            while(temp.next != null && temp.next.val < cur.val){
                temp = temp.next;
            } //cur이 temp.next보다 작은 지점까지 이동 (temp cur temp.next 만들어야함)

            cur.next = temp.next;
            temp.next = cur;

            cur = path;
        }

        
        return dummy.next;
    }
}