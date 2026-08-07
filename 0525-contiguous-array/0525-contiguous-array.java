class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
        }
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum)){
                int len=i-hm.get(sum);
                maxLen=Math.max(maxLen,len);
            }else{hm.put(sum,i);}
 
        }
        return maxLen;
    }
}