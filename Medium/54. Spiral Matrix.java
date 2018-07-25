class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>(); 
        if(matrix.length==0 || matrix[0].length==0)
            return list;
        
        int left=0;
        int right=matrix[left].length-1;
        int top=0;
        int bottom=matrix.length-1;
        int spiral=0;
        
        while(true){
            if(left>right)
                break;
            for(int col=left;col<=right;col++)
                list.add(matrix[top][col]);
            top++;
            
            
            if(top>bottom)
                break;
            for(int row=top;row<=bottom;row++)
                list.add(matrix[row][right]);
            right--;
            
            
            if(left>right)
                break;
            for(int col=right;col>=left;col--)
                list.add(matrix[bottom][col]);
            bottom--;
            
            
            if(top>bottom)
                break;
            for(int row=bottom;row>=top;row--)
                list.add(matrix[row][left]);
            left++;
        }
        return list;
    }
}
