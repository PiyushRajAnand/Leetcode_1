class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int suffix[]=new int[nums.length];
       
        int n=nums.length;
        int m=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            m=Math.min(m,nums[i]);
            suffix[i]=m;
        }
        int l=0;
        for(int i=0;i<n;i++){
            l=Math.max(l,nums[i]);
            if(l-suffix[i]<=k){
                return i;
            }
        }
        return -1;
    }
}