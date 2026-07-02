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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode oldTail=null;
        ListNode newHead=null;
        ListNode oldHead=head;
        int size=0;
        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        ListNode prev=null;
        dummy.next=head;
        if(head==null || head.next==null){
            return head;
        }
        while(curr!=null){
            oldTail=curr;
            curr=curr.next;
            size++;
        }
        curr=head;
        int i=0;
        k=k%size;
        if(k==0){
            return head;
        }
        while(curr!=null && i<size-k-1){
            prev=curr;
            curr=curr.next;
            i++;
        }
        newHead=curr.next;
        curr.next=null;
        oldTail.next=head;
        return newHead;

    }
}