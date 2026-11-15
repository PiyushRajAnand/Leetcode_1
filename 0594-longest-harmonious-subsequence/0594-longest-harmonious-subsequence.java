class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=1;
        int ans=0;
        while(r<nums.length){
            int diff=nums[r]-nums[l];
            if(diff==1){
                ans=Math.max(ans,r-l+1);
            }
            if(diff<=1){
                r++;
            }else{
                l++;
            }
        }
        return ans;
    }
}