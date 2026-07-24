class Solution {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> maxdq=new LinkedList<>();
        LinkedList<Integer> mindq=new LinkedList<>();
        int length=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            int n=nums[right];
            while(maxdq.size()>0 && maxdq.getLast()<n){
                maxdq.removeLast();
            }
            maxdq.add(n);
            while(mindq.size()>0 && mindq.getLast()>n){
                mindq.removeLast();
            }
            mindq.add(n);
            while((maxdq.getFirst()-mindq.getFirst())>limit){
                if(nums[left]==mindq.getFirst()){
                    mindq.removeFirst();
                }
                if(nums[left]==maxdq.getFirst()){
                    maxdq.removeFirst();
                }
                left++;
            }
            length=Math.max(length,right-left+1);
        }
        return length;
    }
}