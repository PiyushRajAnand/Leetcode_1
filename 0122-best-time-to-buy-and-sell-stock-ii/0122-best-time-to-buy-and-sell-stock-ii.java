class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
            maxProfit+=prices[i]-prices[i-1];
        }
        if(maxProfit>0){
            return maxProfit;
        }
        return 0;
    }
}