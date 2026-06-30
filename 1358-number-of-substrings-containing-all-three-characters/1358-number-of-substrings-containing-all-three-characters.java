class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int arr[]=new int[26];
        int left=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            arr[c-'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                count+=s.length()-i;
                arr[s.charAt(left)-'a']--;
                left++;
            }
        }

        return count;
    }
}