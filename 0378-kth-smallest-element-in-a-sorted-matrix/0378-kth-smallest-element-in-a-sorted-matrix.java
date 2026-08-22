class Solution {
    public int counting(int matrix[][],int target){
        int n=matrix.length;
        int count=0;
        int col=n-1;int row=0;
        while(row<n && col>=0){
            if(matrix[row][col]<=target){
                count+=col+1;
                row++;
            }else{
                col--;
            }

        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0];
        int high=matrix[matrix.length-1][matrix.length-1];
        while(low<high){
            int mid=low+(high-low)/2;
            int count=counting(matrix,mid);
            if(count>=k){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}