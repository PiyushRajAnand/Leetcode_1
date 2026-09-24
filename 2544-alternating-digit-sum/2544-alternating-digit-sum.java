class Solution {
    public int alternateDigitSum(int n) {
        int sum=0;
        int flag=0;
        int org=n;
        int rev=0;
        while(n>0){
            rev=rev*10+(n%10);
            n/=10;
        }
        n=org;
        while(rev>0){
            if(flag==0){
                sum+=((rev%10));
            }else if(flag==1){
                sum+=(-(rev%10));
            }
            flag=1-flag;
            rev/=10;
        }
        return sum;
    }
}