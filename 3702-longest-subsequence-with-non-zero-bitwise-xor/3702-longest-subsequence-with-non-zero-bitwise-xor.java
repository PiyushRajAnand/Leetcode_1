class Solution {
    public int longestSubsequence(int[] nums) {
        int zero[]=new int[nums.length];
        Arrays.fill(zero,0);
        if(Arrays.equals(nums,zero)){
            return 0;
        }
        int x=0;
        for(int n:nums){
            x^=n;
        }
        if(x!=0){
            return nums.length;
        }else{
            return nums.length-1;
        }
    }
}