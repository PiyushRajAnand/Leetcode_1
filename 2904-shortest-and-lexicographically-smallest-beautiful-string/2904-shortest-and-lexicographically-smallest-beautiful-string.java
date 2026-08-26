class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
       String ans="";
        for(int i=0;i<s.length();i++){
            int oneCount=0;
            StringBuilder curr=new StringBuilder();
            for(int j=i;j<s.length();j++){
                curr.append(s.charAt(j));
                if(s.charAt(j)=='1'){
                    oneCount++;
                }
                if(oneCount>k){
                    break;
                }
                if(oneCount==k){
                    String currStr=curr.toString();
                    if(ans.isEmpty() || ans.length()>currStr.length() || (ans.length()==currStr.length() && currStr.compareTo(ans)<0)){
                        ans=currStr;
                    }
                }
            }

        }
        return ans;
    }
}