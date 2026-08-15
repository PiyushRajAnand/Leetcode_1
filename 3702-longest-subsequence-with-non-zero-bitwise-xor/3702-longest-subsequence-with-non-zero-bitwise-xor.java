class Solution {
    public int longestSubsequence(int[] nums) {
        int zeroCount=0;
        int x=0;
        for(int n:nums){
            x^=n;
            if(n==0){
                zeroCount++;
            }
        }
        if(x!=0){
            return nums.length;
        }else if(zeroCount==nums.length){
            return 0;
        }
        return nums.length-1;
    }
}