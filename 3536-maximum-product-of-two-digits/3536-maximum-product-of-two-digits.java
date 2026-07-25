class Solution {
    public int maxProduct(int n) {
        String s=String.valueOf(n);
        int len=s.length();
        int a[]=new int[len];
        for(int i=0;i<len;i++){
            a[i]=s.charAt(i)-'0';
        }
        int mul=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
               if((a[i]==0 || a[j]==0) && len<=2) return 0;
               if(i!=j){
               mul=Math.max(mul,a[i]*a[j]);
               }
            }
        }
        return mul;
    }
}