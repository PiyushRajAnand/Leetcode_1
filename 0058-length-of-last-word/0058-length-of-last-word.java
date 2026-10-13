class Solution {
    public int lengthOfLastWord(String s) {
        int len=s.length()-1;
        int lenOfWord=0;
        while(len>=0 && s.charAt(len)==' '){
            len--;
        }
        while(len>=0 && s.charAt(len)!=' '){
            lenOfWord++;
            len--;
        }
        return lenOfWord;
    }
}