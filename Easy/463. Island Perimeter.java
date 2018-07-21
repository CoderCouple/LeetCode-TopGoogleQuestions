package TopGoogleQuestions;
/**
*
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 Grid cells are connected horizontally/vertically (not diagonally). 
 The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 Determine the perimeter of the island.

 Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Answer: 16
 Explanation: The perimeter is the 16 yellow stripes in the image below:
*
* */
public class IslandPerimeter {
        public int islandPerimeter(int[][] grid) {
            if(grid==null || grid.length==0)
                return 0;

            int [][] marker = new int [grid.length][grid[0].length];
            for(int row=0;row<grid.length;row++)
                for(int col=0;col<grid[row].length;col++ )
                    if(grid[row][col]==1)
                        return getIslandPerimeter(grid,marker,row,col);

            return 0;
        }

        public int getIslandPerimeter(int[][] grid, int [][] marker, int row, int col)  {
            if(row<0 || row>=grid.length || col<0 || col>=grid[row].length)
                return 1;

            if(grid[row][col]==0)
                return 1;

            if(marker[row][col]==-1)
                return 0;

            marker[row][col]=-1;

            int result=0;
            return getIslandPerimeter(grid,marker,row-1,col) + getIslandPerimeter(grid,marker, row+1,col) + getIslandPerimeter(grid,marker,row, col-1) +getIslandPerimeter(grid,marker, row, col+1);
        }

}
