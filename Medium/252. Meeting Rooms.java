package TopGoogleQuestions.Medium;

/***

 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

 Example 1:

 Input: [[0,30],[5,10],[15,20]]
 Output: false
 Example 2:

 Input: [[7,10],[2,4]]
 Output: true
 * **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRooms {


      public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }
        public boolean canAttendMeetings(Interval[] intervals) {
            int result=0;
            if(intervals==null || intervals.length==0)
                return true;

            List<Integer> startTime = new ArrayList<Integer>();
            List<Integer> endTime = new ArrayList<Integer>();

            for(Interval i : intervals){
                startTime.add(i.start);
                endTime.add(i.end);
            }

            Collections.sort(startTime);
            Collections.sort(endTime);

            int startIdx=0;
            int endIdx=0;
            int counter=0;

            while(startIdx<startTime.size()){
                if(startTime.get(startIdx)<endTime.get(endIdx)){
                    counter++;
                    startIdx++;
                } else {
                    result=Math.max(result,counter);
                    endIdx++;
                    counter=startIdx-endIdx;
                }
            }
            result=Math.max(result,counter);
            return result==1;
        }


}
