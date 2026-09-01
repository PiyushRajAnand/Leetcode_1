class Solution {
    public int leastInterval(char[] tasks, int n) {
        int chr[]=new int[26];
        int maxCount=0;
        int max=0;
        for(int i=0;i<tasks.length;i++){
            char c=tasks[i];
            chr[c-'A']++;
            if(max==chr[c-'A']){
                maxCount++;
            }else if(max<chr[c-'A']){
                max=chr[c-'A'];
                maxCount=1;
            }
        }
        int part=max-1;
        int partLength=n-(maxCount-1);
        int remaining=part*partLength;
        int taskAvail=tasks.length-max*maxCount;
        int ideal=Math.max(0,remaining-taskAvail);
        return ideal+tasks.length;
    }
}