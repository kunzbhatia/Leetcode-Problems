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
    public ListNode middleNode(ListNode head) 
    {
        double count=0;
        ListNode current=head;
        ListNode search=head;
        while(current.next!=null)
        {
            current=current.next;
            count=count+1;
        }

        count=Math.ceil(count/2);
        while(count!=0)
        {
            search=search.next;
            count--;
        }
        return search;

    }
}