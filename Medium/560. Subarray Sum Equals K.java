package FBQuestions;

import java.util.HashMap;
import java.util.Map;


/****
 *
 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 
 
 *
 * 
 * **/

public class LongestSubSequence_Count {

    public int subarraySum(int[] nums, int k) {
        if(nums.length==0)
            return Integer.MIN_VALUE;

        Map<Integer,Integer> cumulativeMap = new HashMap<Integer,Integer>();
        cumulativeMap.put(0,1);

        int count=0;
        int sum=0;

        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            if(cumulativeMap.containsKey(sum-k))
                count+=(int)cumulativeMap.get(sum-k);
            cumulativeMap.put(sum, cumulativeMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
