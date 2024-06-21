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
class Solution 
{
    public ListNode merge(ListNode head1,ListNode head2) 
    {
      ListNode t1=head1;
      ListNode t2=head2;
      ListNode dnode=new ListNode(-1);
      ListNode temp=dnode;

      while(t1!=null && t2!=null)
      {
        if(t1.val<t2.val)
        {
            temp.next=t1;
            temp=t1;
            t1=t1.next;
        }
        else
        {
            temp.next=t2;
            temp=t2;
            t2=t2.next;
        }
      }

      if(t1!=null) temp.next=t1;
      if(t2!=null) temp.next=t2;

      return dnode.next;
    }


    public ListNode middleNode(ListNode head) 
    {
         if (head == null || head.next == null) 
            return head;
        ListNode fast=head;
        ListNode slow=head;

        while(fast.next != null && fast.next.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }        
        return slow;
    }

    public ListNode sortList(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        ListNode middle=middleNode(head);

        ListNode lefthead=head;
        ListNode righthead=middle.next;
        middle.next=null; 

        lefthead=sortList(lefthead);
        righthead=sortList(righthead);

        return merge(lefthead,righthead);
    }
}