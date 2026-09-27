class Solution {
    public int smallestEvenMultiple(int n) {
         int i=1;
         while(true){
            if(n*i%2==0){
                return n*i;
            }
            i++;
         }
        //  return 0;
    }
}