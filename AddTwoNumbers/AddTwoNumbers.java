//Space complexity : O(max(m,n)). The length of the new List is at most max(m,n) + 1
//Time complexity: O(max(m,n)). Assume m and n represents the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above // iterates at most \max(m, n)max(m,n) times.

// Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
        ListNode l3;
        ListNode ptr;
        int carry = 0;
        int num = 0;
        
        if(l1 != null){
            num = l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            num += l2.val;
            l2 = l2.next;
        }
        
        if(num > 9){
            carry = 1;
            num = num - 10;
        }
        
        l3 = new ListNode(num);
        ptr = l3;
        
        
        // 1 -> 2 -> 3 + 2->4->1   [321 + 142]
        while(l1 != null && l2 != null){
            
            num = l1.val;
            num += l2.val;
            num += carry;
            carry = 0;
            if(num > 9){
                carry = 1;
                num = num - 10;
            }
            
            l1 = l1.next;
            l2 = l2.next;
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }
        
        
        while(l1 != null){
            
            num = l1.val;
            num += carry;
            carry = 0;
            if(num > 9){
                carry = 1;
                num = num - 10;
            }
            
            l1 = l1.next;
            ptr.next = new ListNode(num);
            ptr = ptr.next;
            
        }
        
        while(l2 != null){
            num = l2.val;
            num += carry;
            carry = 0;
            if(num > 9){
                carry = 1;
                num = num - 10;
            }
            
            l2 = l2.next;
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }
        
        if(carry == 1){
            ptr.next = new ListNode(carry);
        }
        
        
        
        
        
        return l3;
    }
}