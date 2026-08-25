class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int multiple=1;
        while(set.contains(multiple*k)){
            multiple++;
        }
        return k*multiple;
    }
}