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
    public ListNode partition(ListNode head, int x) {
        ListNode smallList=new ListNode(0);
        ListNode largerList=new ListNode(0);
        smallList.next=head;
        largerList.next=head;
        ListNode small=smallList;
        ListNode larger=largerList;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                small.next=curr;
                small=curr;
            }else{
                larger.next=curr;
                larger=curr;
            }
            curr=curr.next;
        }
        larger.next=null;
        small.next=largerList.next;
        return smallList.next;
    }
}