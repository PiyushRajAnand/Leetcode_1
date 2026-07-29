class Solution {
    
    public boolean isHappy(int n) {
        if(n==1 || n==7){ return true; }
        if(n<10){ return false; }
        int m=0,rev=0;
        while(n>0){
            m=n%10;
            rev+=(m*m);
            n/=10;
        }
        return isHappy(rev);
    }
}