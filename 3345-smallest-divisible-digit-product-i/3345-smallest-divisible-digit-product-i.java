class Solution {
    public int smallestNumber(int n, int t) {
        while(true
        ){
           int m=n;
           int p=1;
           while(m>0){
            p*=(m%10);
            m/=10;
           }
           if(p%t==0){
            return n;
           }
           n++;
        }
    }
}