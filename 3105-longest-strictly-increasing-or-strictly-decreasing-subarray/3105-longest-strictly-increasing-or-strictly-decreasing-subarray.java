class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1;
        int max=1;
        int min=1;
        for(int i=0;i<nums.length-1;i++){
            max= nums[i]<nums[i+1]?max+1:1;
            min= nums[i]>nums[i+1]?min+1:1;
            ans=Math.max(ans,Math.max(min,max));
        }
        return ans;
    }
}