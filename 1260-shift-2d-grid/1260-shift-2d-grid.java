class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int total=m*n;
        k%=total;
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int l=i*n+j;
                int newIndex=(l+k)%total;
                int row=newIndex/n;
                int col=newIndex%n;
                ans[row][col]=grid[i][j];
            }
        }
        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<m;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(ans[i][j]);
            }
            list.add(row);
        }
        return list;
    }
}