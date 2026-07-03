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
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode start=dummy;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                start.next=left;
                left=left.next;
            }else{
                start.next=right;
                right=right.next;
            }
            start=start.next;
        }
        if(left!=null){
            start.next=left;
        }
        if(right!=null){
            start.next=right;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l=sortList(head);
        ListNode r=sortList(slow);
        return merge(l,r);
    }
}