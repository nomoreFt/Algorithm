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
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        ListNode current = head;
        while(current != null) {
            ListNode temp = current.next; // 맨 앞을 제외한 노드들 임시 저장
            current.next = tail; // 맨 앞 노드를 tail에 붙인다.
            tail = current; // slow에 붙였기 때문에 tail을 slow 로 치환
            current = temp; //slow는 계속해서 잘라서 써야하기 때문에 temp로 치환
        }
        return tail;
    }
}