class Solution {
    public int GCD(int m,int n){
        if(n==0){
            return Math.abs(m);
        }
        return GCD(n,m%n);
    }
    public int findGCD(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        return GCD(max,min);
    }
}