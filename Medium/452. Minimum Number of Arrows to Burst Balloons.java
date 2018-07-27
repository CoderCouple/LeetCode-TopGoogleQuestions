package TopGoogleQuestions.Medium;

/**
 *
 There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

 An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

 Example:

 Input:
 [[10,16], [2,8], [1,6], [7,12]]

 Output:
 2

 Explanation:
 One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 *
 **/

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowToBurstBaloons {
        public int findMinArrowShots(int[][] points) {
            if(points==null || points.length==0)
                return 0;

            Arrays.sort(points,new Comparator<int[]>(){
                public int compare(int [] p1, int [] p2){
                    if(p1[0]==p2[0])
                        return p1[1]-p2[1];
                    return p1[0]-p2[0];
                }
            });

            int res=1;
            int index=0;
            int currEnd=points[0][1];
            while(index<points.length){
                if(points[index][0]<=currEnd){
                    currEnd=Math.min(currEnd,points[index][1]);
                }else{
                    currEnd=points[index][1];
                    res++;
                }
                index++;
            }
            return res;
        }
    }

