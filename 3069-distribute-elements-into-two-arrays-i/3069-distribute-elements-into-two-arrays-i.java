class Solution {
    public int[] resultArray(int[] nums) {
        int a[]=new int[nums.length];
        int b[]=new int[nums.length];
        int n1=0;
        int n2=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                a[n1++]=nums[i];
            }else if(i==1){
                b[n2++]=nums[i];
            }else{
                if(a[n1-1]>b[n2-1]){
                    a[n1++]=nums[i];
                }else{
                    b[n2++]=nums[i];
                }
            }
        }
        for(int i=0;i<n2;i++){
            a[n1++]=b[i];
        }
        return a;
    }
}