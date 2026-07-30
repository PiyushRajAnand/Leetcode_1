class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int blocks=n/8;
        return ((blocks+1)*blocks*4)+((n%8)*(blocks+1));
    }
}