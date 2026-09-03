class Solution {
    public int maximumPopulation(int[][] logs) {
         int p[]=new int[2051];
         int res=0; // strore the current ealiest year with maximum pollution
         for(var l:logs){
            ++p[l[0]];
            --p[l[1]];
         }
         for(int i=1950;i<2051;i++){
            p[i]+=p[i-1];
            res=p[i]>p[res]?i:res;
         }
         return res;
    }
}