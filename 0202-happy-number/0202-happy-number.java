class Solution {
    public int digitSum(int n){
        int rev=0;
        int m=0;
        while(n>0){
            m=n%10;
            rev+=(m*m);
            n/=10;
        }
        return rev;
    }
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        
        while(!set.contains(n)){
            set.add(n);
            n=digitSum(n);
            if(n==1){
                return true;
            }
        }
        return false;
    }
}