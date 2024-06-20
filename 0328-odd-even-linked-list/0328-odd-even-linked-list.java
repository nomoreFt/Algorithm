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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode result = odd;        

        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next; // 홀수 노드의 다음 노드를 설정
            odd = odd.next; // 홀수 노드 포인터 이동

            even.next = even.next.next; // 짝수 노드의 다음 노드를 설정
            even = even.next; // 짝수 노드 포인터 이동
        }

        odd.next = evenHead; // 홀수 리스트의 끝을 짝수 리스트의 시작과 연결

        return result;
    }
}