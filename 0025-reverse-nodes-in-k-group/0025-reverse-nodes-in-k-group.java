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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        // creating dummy node to prevent edge case
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        // starting from dummy as because to prevent edge case
        ListNode start=dummy;
        while(true){
            ListNode kth=start;
            // finding the kth node by iterating for each group 
            for(int i=0;i<k && kth!=null;i++){
                kth=kth.next;
            }
            if(kth==null){
                break;
            }
            ListNode rightP=kth.next; //node after kth node which would help to keep track of node 
            ListNode prev=rightP; 
            ListNode curr=start.next; 
            while(curr!=rightP){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            // RECONNECTION part the most important one 
            ListNode temp=start.next;
            start.next=kth;
            start=temp;
        }
        return dummy.next;
    }
}