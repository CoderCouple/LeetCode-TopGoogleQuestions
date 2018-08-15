package FBQuestions;
/**
 *
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * **/

public class LongestSubSequence_MaxSum {

    public int maxSubArraySum(int array []){
        if(array.length==0)
            return Integer.MIN_VALUE;

        int global_max=array[0];
        int curr_max=array[0];

        for(int i=1;i<array.length;i++){
            curr_max=Math.max(array[i],array[i]+curr_max);
            global_max=Math.max(global_max,curr_max);
        }
        return global_max;
    }

    public static void main(String[] args)
    {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        LongestSubSequence_MaxSum m = new LongestSubSequence_MaxSum();
        int max_sum = m.maxSubArraySum(a);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }
}
