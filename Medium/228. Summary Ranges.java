package TopGoogleQuestions.Medium;

import java.util.ArrayList;
import java.util.List;

/***
 *
 *
 Given a sorted integer array without duplicates, return the summary of its ranges.

 Example 1:

 Input:  [0,1,2,4,5,7]
 Output: ["0->2","4->5","7"]
 Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 Example 2:

 Input:  [0,2,3,4,6,8,9]
 Output: ["0","2->4","6","8->9"]
 Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

 *
 * ***/
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();

        if(nums==null || nums.length==0)
            return result;

        int start=nums[0];
        int end=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]==end+1)
                end=nums[i];
            else {
                result.add(createRange(start,end));
                start=nums[i];
                end=nums[i];
            }
        }
        result.add(createRange(start,end));
        return result;
    }

    public String createRange(int start,int end){
        if(start==end)
            return ""+start;
        else return ""+start+"->"+end+"";
    }
}
