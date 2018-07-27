package TopGoogleQuestions.Medium;

/***
 *
 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
 *
 * **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeInterval {
    class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }


        public List<Interval> merge(List<Interval> intervals) {

            List<Interval> result = new ArrayList<Interval>();
            List<Integer> startInterval = new ArrayList<Integer>();
            List<Integer> endInterval = new ArrayList<Integer>();

            if(intervals.size()<=1)
                return intervals;
            for(int i=0;i<intervals.size();i++){
                startInterval.add(intervals.get(i).start);
                endInterval.add(intervals.get(i).end);
            }

            Collections.sort(startInterval);
            Collections.sort(endInterval);

            int start = startInterval.get(0);
            int end =  endInterval.get(0);

            for(int i=1;i<intervals.size();i++){
                if(start<=startInterval.get(i) && startInterval.get(i)<=end){
                    start = Math.min(start,startInterval.get(i));
                    end = Math.max(end,endInterval.get(i));
                } else {
                    Interval item = new Interval(start,end);
                    result.add(item);
                    start=startInterval.get(i);
                    end=endInterval.get(i);
                }
            }
            result.add(new Interval(start,end));

            return result;

        }
}
