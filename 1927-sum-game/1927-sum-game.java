class Solution {
    public boolean sumGame(String s) {
        double res = 0;

        int n = s.length();

        for (int i = 0; i < n; i++) {

            double value;

            // '?' is treated as 4.5
            if (s.charAt(i) == '?') {
                value = 4.5;
            } else {
                value = s.charAt(i) - '0';
            }

            // First half -> add
            // Second half -> subtract
            if (i < n / 2) {
                res += value;
            } else {
                res -= value;
            }
        }

        // res != 0 -> Alice can win
        // res == 0 -> Bob can force equality
        return res != 0;
    }
}