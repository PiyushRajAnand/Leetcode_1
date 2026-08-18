class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(k==1){
            for(int i=0;i<n;i++){
                if(map.get(nums[i])==1){
                    ans=Math.max(ans,nums[i]);
                }
            }
            return ans;
        }
        ans=-1;
        if(k==n){
            for(int n1:nums){
                ans=Math.max(ans,n1);
            }
            return ans;
        }
        ans=-1;
        if(map.get(nums[0])==1){
            ans=Math.max(ans,nums[0]);
            
        }
        if(map.get(nums[n-1])==1){
            ans=Math.max(nums[n-1],ans);
            
        }
    return ans;
    }
}