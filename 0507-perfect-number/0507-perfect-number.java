class Solution {
    public boolean PN(int n){
        int sum=1;int m=n;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                sum+=i;
                if(i!=n/i){
                    sum+=(n/i);
                }
            }
        }
        return sum==m;
    }
    public boolean checkPerfectNumber(int num) {
        if(num<2){
            return false;
        }
        return PN(num);
    }
}