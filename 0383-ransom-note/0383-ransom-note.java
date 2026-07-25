class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int hash[]=new int[26];
        for(char c:ransomNote.toCharArray()){
            hash[c-'a']++;
        }
        for(char c:magazine.toCharArray()){
            hash[c-'a']--;
        }
        for(int n:hash){
            if(n>0){
                return false;
            }
        }
        return true;
    }
}