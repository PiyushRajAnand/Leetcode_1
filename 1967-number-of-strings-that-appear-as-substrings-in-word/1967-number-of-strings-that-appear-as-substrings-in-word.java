class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int patternCount=0;
        for(int i=0;i<patterns.length;i++){
            String pattern=patterns[i];
            if(word.contains(pattern)){
                patternCount++;
            }
        }
        return patternCount;
    }
}