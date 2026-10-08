class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int level=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if((c=='('?level++:--level)>0){
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}