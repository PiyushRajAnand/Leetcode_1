class Solution {
    public String smallestSubsequence(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,i);
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>c && map.get(stack.peek())>i){
                set.remove(stack.pop());
            }
            stack.push(c);
            set.add(c);
        }
        for(char c:stack){
            sb.append(c);
        }
        return sb.toString();
    }
}