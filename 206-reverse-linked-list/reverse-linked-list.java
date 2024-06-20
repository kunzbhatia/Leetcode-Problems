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
    public ListNode reverse(ListNode head) 
    {
         if (head==null || head.next==null) return head;

         ListNode newHead=reverse(head.next);

         ListNode front=head.next;
         front.next=head;
         head.next=null;

         return newHead;


    }
    public ListNode reverseList(ListNode head) 
    {

        // if (head==null || head.next==null) return head;
        
        // ListNode temp=head,back=null;
        
        // while(temp!=null)
        // {
        //     ListNode front=temp.next;
        //     temp.next=back;

        //     back=temp;
        //     temp=front;
        // }

        return reverse(head);
    }
}