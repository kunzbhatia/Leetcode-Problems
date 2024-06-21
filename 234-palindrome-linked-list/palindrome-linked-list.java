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
    public boolean isPalindrome(ListNode head) 
    {
        if (head==null || head.next==null) return true;
        ListNode fast=head;
        ListNode slow=head;
        fast=fast.next.next;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }  

        ListNode NewHead=reverse(slow.next);

        ListNode first=head;
        ListNode second=NewHead;

        while(second!=null)
        {
            if(first.val!=second.val)
            {
                reverse(NewHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }

        reverse(NewHead);
        return true;
    }

    public ListNode reverse(ListNode head) 
    {

        if (head==null || head.next==null) return head;
        
        ListNode temp=head,back=null;
        
        while(temp!=null)
        {
            ListNode front=temp.next;
            temp.next=back;

            back=temp;
            temp=front;
        }

        return back;
    }
}