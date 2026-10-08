class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int level=0;
        for(char c:s.toCharArray()){
            if((c=='('?level++:--level)>0){
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}