package TopGoogleQuestions;
/**
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 
 Example:
 n = 10, I pick 6.

 Return 6.
 **/
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int start=1;
        int end=n;
        int myGuess=1;

        while(start<=end){
            myGuess=start+(end-start)/2;
            int limit=guess(myGuess);

            if(limit==0)
                break;
            else if(limit==1)
                start=myGuess+1;
            else end=myGuess-1;
        }

        return myGuess;
    }

    public int guess(int num){
        return num;
    }
}
