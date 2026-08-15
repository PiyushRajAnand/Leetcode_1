class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int zeroCount=0;
        int x=0;
        for(int t:nums){
            x^=t;
            if(t==0){
                zeroCount++;
            }
        }
        if(x!=0){
            return n;
        }else if(zeroCount==n){
            return 0;
        }
        return n-1;
    }
}