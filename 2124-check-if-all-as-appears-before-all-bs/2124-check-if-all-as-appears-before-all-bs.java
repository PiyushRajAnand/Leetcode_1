class Solution {
    public boolean checkString(String s) {
        
        int n=s.length();
        int firstPosOfA=-1;
        int firstPosOfB=n;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                firstPosOfA=i;
            }
            else if(s.charAt(i)=='b' && firstPosOfB==n){
                firstPosOfB=i;
            }
        }
        return firstPosOfA<firstPosOfB;
    }
}