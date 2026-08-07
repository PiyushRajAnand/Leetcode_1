class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int ps=0;
        for(int i=0;i<nums.length;i++){
            ps+=nums[i];
            int ms=ps%k;
            if(map.containsKey(ms)){
                if(i-map.get(ms)>1){
                    return true;
                }
            }else{
                map.put(ms,i);
            }
        }
        return false;
    }
}