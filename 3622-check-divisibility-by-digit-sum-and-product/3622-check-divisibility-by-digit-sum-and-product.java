class Solution {
    public boolean checkDivisibility(int n) {
        int m=n;
        int sum=0;
        int r=0;
        int prod=1;
        while(n>0){
        r=n%10;
        sum+=r;
        prod*=r;
        n=n/10;
        }
        return m%(sum+prod)==0;
    }
}