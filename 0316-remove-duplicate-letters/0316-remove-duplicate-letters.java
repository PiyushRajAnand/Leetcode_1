class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        HashMap<Character,Integer> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        // IF THERE IS INDEX IN THE HASHMAP THAT IS GREATER THAN THAT OF CURRENT INDEX THEN IT MUST BE APPEARED AGAIN
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