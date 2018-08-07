/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
          if(lists==null || lists.length==0)
                return null;

            ListNode[] indexList = new ListNode[lists.length];
            System.arraycopy(lists,0,indexList,0,lists.length);
            ListNode head=new ListNode(-1);
            ListNode tail=head;
            int minIndex=0;
            int count=0;
            while(count<indexList.length){
                count=0;
                minIndex=0;
                ListNode minNode=null;
                for (ListNode l : indexList)
                    if (l!=null)
                        minNode=l;
                for(int i=0; i<indexList.length;i++) {

                    if (indexList[i] != null) {
                        if (minNode.val >= indexList[i].val) {
                            minNode = indexList[i];
                            minIndex = i;
                        }
                    } else {
                        count++;
                    }
                }

                    tail.next = minNode;
                    if(indexList[minIndex]!=null)
                    indexList[minIndex] = indexList[minIndex].next;
                    tail=tail.next;
            }
            return head.next;
        }
}
