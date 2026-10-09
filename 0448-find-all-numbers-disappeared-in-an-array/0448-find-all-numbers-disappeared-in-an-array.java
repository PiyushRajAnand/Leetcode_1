class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(i+1)){
                arr.add(i+1);
            }
        }
        return arr;
    }
}