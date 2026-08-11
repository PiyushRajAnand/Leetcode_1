class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){ return false; }
        HashMap<Character,Integer> hm=new HashMap<>();
        HashMap<Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),i);
            }
            if(!hm2.containsKey(t.charAt(i))){
                hm2.put(t.charAt(i),i);
            }
            if(!hm.get(s.charAt(i)).equals(hm2.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}