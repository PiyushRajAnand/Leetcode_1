class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int max=0;
        for(int n:set){
            if(!set.contains(n-1)){
                int length=1;
                while(set.contains(n+length)){
                    length+=1;
                }
                max=Math.max(max,length);
            }
        }
        return max;
    }
}