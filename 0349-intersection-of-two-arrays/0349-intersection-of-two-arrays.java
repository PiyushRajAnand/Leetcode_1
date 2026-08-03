class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num=new HashSet<>();
        Set<Integer> result=new HashSet<>();
        for(int nums:nums1){
            num.add(nums);
        }
        for(int numd:nums2){
            if(num.contains(numd)){
                result.add(numd);
            }
        }
        int a[]=new int[result.size()];
        int index=0;
        for(int n:result){
            a[index++]=n;
        }
        return a;
        }
}