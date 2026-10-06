class Solution {
    public boolean isPowerOfThree(int n) {
        double maxPow=Math.pow(3,19);
        return n>0 && maxPow%n==0;
    }
}