package TopGoogleQuestions.Medium;

/**
 *
 Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

 You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

 Example 1:
 Input: "19:34"
 Output: "19:39"
 Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.

 Example 2:
 Input: "23:59"
 Output: "22:22"
 Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 
 *
 * ***/

import java.util.HashSet;
import java.util.Set;


public class NextClosestTime {
    public String nextClosestTime(String time) {
        String result="";
        int startTime= 60*Integer.parseInt(time.substring(0,2));
        int currTime=startTime += Integer.parseInt(time.substring(3));

        Set<Integer> set = new HashSet<Integer>();
        for(char c : time.toCharArray())
            if(c!=':')
                set.add(c-'0');

        while(true){
            currTime=(currTime+1)%(24*60);
            int digits [] = {currTime/60/10,currTime/60%10,currTime%60/10,currTime%60%10};
            int count=0;
            for(int d : digits){
                if(!set.contains(d))
                    break;
                count++;
            }
            if(count>3)
                break;

        }
        return String.format("%02d:%02d",currTime/60,currTime%60);
    }
}
