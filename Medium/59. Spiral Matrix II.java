package TopGoogleQuestions;

/**
 *
 Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 Example:

 Input: 3
 Output:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 * **/

public class SpiralMatrix_II {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int [n][n];
        if(n==0)
            return matrix;

        int left=0;
        int right=matrix[left].length-1;
        int top=0;
        int bottom=matrix.length-1;
        int spiral=0;

        while(true){
            if(left>right)
                break;
            for(int col=left;col<=right;col++)
                matrix[top][col]=++spiral;
            top++;


            if(top>bottom)
                break;
            for(int row=top;row<=bottom;row++)
                matrix[row][right]=++spiral;
            right--;


            if(left>right)
                break;
            for(int col=right;col>=left;col--)
                matrix[bottom][col]=++spiral;
            bottom--;


            if(top>bottom)
                break;
            for(int row=bottom;row>=top;row--)
                matrix[row][left]=++spiral;
            left++;
        }
        return matrix;
    }
}
