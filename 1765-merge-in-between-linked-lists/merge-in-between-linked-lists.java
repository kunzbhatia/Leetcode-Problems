class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = list1;
        for (int i = 1; i < a; i++)
            left = left.next;  //finding leftmost node where to change pointer to second list
        
        ListNode middle = left;
        for (int i = a; i <= b; i++)
            middle = middle.next;   //traversing till the node to be deleted
        
		left.next = list2;  //chnaging pointer to second list
        while (list2.next != null)
            list2 = list2.next;   //moving pointer till last;
        
        list2.next = middle.next;  //making last node of second list point to next of middle
        return list1;
    }
}