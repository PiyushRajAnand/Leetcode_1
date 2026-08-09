class Solution {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int prefix[]=new int[n+1];
        prefix[0]=arr[0];
        for(int i=0;i<arr.length;i++){
            prefix[i+1]=prefix[i]^arr[i];
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int k=i+1;k<n;k++){
                if(prefix[i]==prefix[k+1]){
                    count+=(k-i);
                }
            }
        }
        return count;
    }
}