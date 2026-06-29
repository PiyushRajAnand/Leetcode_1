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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode start=dummy;
        while(true){
            ListNode kth=start;
            for(int i=0;i<2 && kth!=null;i++){
                kth=kth.next;
            }
            if(kth==null){
                break;
            }
            ListNode rightp=kth.next;
            ListNode prev=rightp;
            ListNode curr=start.next;
            while(curr!=rightp){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode temp=start.next;
            start.next=kth;
            start=temp;
        }
        return dummy.next;
    }
}