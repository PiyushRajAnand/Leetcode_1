class Solution {
    public int maxProduct(int[] nums) {
        int mul=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                mul=Math.max(mul,(nums[i]-1)*(nums[j]-1));
            }
        }
        return mul;
    }
}