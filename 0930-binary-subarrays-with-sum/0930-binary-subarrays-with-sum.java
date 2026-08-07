class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int currentSum=0;
        for(int num:nums){
            currentSum+=num;
            int r=currentSum-goal;
            if(map.containsKey(r)){
                count+=map.getOrDefault(r,0);
            }
            map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        }
        return count;
    }
}