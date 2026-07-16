class Solution {
    public int gcd(int m,int n){
        if(n==0){
            return Math.abs(m);
        }
        return gcd(n,m%n);
    }
    public long gcdSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int prefixGCD[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            prefixGCD[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefixGCD);
        int left=0;
        int right=prefixGCD.length-1;
        long sum=0;
        while(left<right){
           int b=gcd(prefixGCD[left],prefixGCD[right]);
           sum+=b;
           left++;
           right--;
        }
        return sum;
    }
}