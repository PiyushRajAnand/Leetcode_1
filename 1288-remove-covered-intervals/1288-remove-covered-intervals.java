class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]!=b[0])?a[0]-b[0]:b[1]-a[1]);
        int count=0;
        int present=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>present){
                count++;
                present=intervals[i][1];
            }
        }
        return count;
    }
}