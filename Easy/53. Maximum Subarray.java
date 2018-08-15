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

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return Integer.MIN_VALUE;
        
        int cur_max=nums[0];
        int global_max=nums[0];

        for(int i=1; i<nums.length; i++){
            cur_max=Math.max(cur_max+nums[i],nums[i]);
            global_max=Math.max(cur_max,global_max);
        }
        return global_max;
    }
}
