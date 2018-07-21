class Solution {
    public boolean judgeCircle(String moves) {
        int upCounter=0; int leftCounter=0;
        for(char move : moves.toCharArray())
            if(move=='U')
                upCounter++;
            else if(move=='D')
                upCounter--;
            else if(move=='L')
                leftCounter++;
            else leftCounter--;
        
        return (upCounter==0 && leftCounter==0);
    }
}
