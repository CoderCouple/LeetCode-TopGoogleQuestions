package TopGoogleQuestions.Medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 Example 1:
 Input: [ [1,2], [2,3], [3,4], [1,3] ]

 Output: 1

 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 Example 2:
 Input: [ [1,2], [1,2], [1,2] ]

 Output: 2

 Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 Example 3:
 Input: [ [1,2], [2,3] ]

 Output: 0

 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 
 * **/

public class NonOverlapingIntervals {

    class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }


        public int eraseOverlapIntervals(Interval[] intervals) {
            if(intervals==null || intervals.length==0)
                return 0;

            Arrays.sort(intervals,new Comparator<Interval>(){
                public int compare(Interval one, Interval two){
                    if(one.start==two.start)
                        return one.end-two.end;
                    return one.start-two.start;
                }
            });

            int index=0;
            int result=1;
            int currEndTime=intervals[0].end;
            while(index<intervals.length){
                if(intervals[index].start>=currEndTime){
                    result++;
                    currEndTime=intervals[index].end;
                }else{
                    currEndTime=Math.min(currEndTime,intervals[index].end);
                }
                index++;
            }
            return intervals.length-result;
        }

}
