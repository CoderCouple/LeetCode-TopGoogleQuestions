package TopGoogleQuestions;
/*
*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
* 
* */
public class JudgeRouteCircle {
    public boolean judgeCircle1(String moves) {
        int upCounter=0; int leftCounter=0;
        for(char move : moves.toCharArray())
            switch(move){
                case 'U':
                    upCounter++;
                    break;
                case 'D':
                    upCounter--;
                    break;
                case 'L':
                    leftCounter++;
                    break;
                case 'R':
                    leftCounter--;
                    break;
            }
        return (upCounter==0 && leftCounter==0);
    }

    public boolean judgeCircle2(String moves) {
        int upCounter=0; int leftCounter=0;
        for(char move : moves.toCharArray())
            switch(move){
                case 'U':
                    upCounter++;
                    break;
                case 'D':
                    upCounter--;
                    break;
                case 'L':
                    leftCounter++;
                    break;
                case 'R':
                    leftCounter--;
                    break;
            }
        return (upCounter==0 && leftCounter==0);
    }
}
