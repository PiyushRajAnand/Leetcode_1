class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long r=0;int p=0;long csum=0;
        while(n>0){
            r=n%10;
            csum+=r;
            if(r!=0){
                sum=(long)(r*Math.pow(10,p))+sum;
                p++;
            }
            n/=10;
        }
        return csum*sum;
    }
}