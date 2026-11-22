class Solution {
    public boolean checkString(String s) {
        // int i=s.indexOf('a');
        // int j=s.indexOf('b');
        // if(i==-1 || j==-1){
        //     return true;
        // }
        // boolean ai=true;
        // boolean bi=true;
        // while(i<j){
        //     if(s.charAt(i)!='a'){
        //         ai=false;
        //     }
        //     i++;
        // }
        // while(j<s.length()){
        //     if(s.charAt(j)!='b'){
        //         bi=false;
        //     }
        //     j++;
        // }
        // return ai && bi;
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