package FBQuestions;


/**
 *
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists begin to intersect at node c1 :

 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 Credits:
 Special thanks to @stellari for adding this problem and creating all test cases.

 *
 * **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class IntersectionOfLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null)
            return null;

        ListNode currA=headA;
        ListNode currB=headB;

        int lenA=0;
        int lenB=0;

        while(currA!=null){
            lenA++;
            currA=currA.next;
        }

        while(currB!=null){
            lenB++;
            currB=currB.next;
        }

        currA=headA;
        currB=headB;

        if(lenA>lenB){
            for(int i=1;i<=lenA-lenB;i++)
                currA=currA.next;
        } else if(lenB>lenA){
            for(int i=1;i<=lenB-lenA;i++)
                currB=currB.next;
        }

        while(currA!=null && currB!=null){
            if(currA==currB)
                return currA;
            currA=currA.next;
            currB=currB.next;
        }

        return null;
    }

    public static void main(String [] args){

    }
}
