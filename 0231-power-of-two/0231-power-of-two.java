class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        int i=2;
        for(int j=1;Math.pow(i,j)<=n;j++){
            if(n/Math.pow(2,j)==1){
                return true;
            }
        }
        return false;
    }
}