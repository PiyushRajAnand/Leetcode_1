class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1;
        int b=-1;
        int c=-1;
        int count=0;int min=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                a=i;
            }else if(ch=='b'){
                b=i;
            }else if(ch=='c'){
                c=i;
            }
            min=Math.min(a,Math.min(b,c));
            if(a>-1 && b>-1 && c>-1){
                  count+=(1+min);
            }
        }
        return count;
    }
}