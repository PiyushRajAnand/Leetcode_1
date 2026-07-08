class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // prefix count of non-zero digits
        int[] nonZeroCnt = new int[n + 1];

        // prefix sum of digits (0 contributes nothing)
        int[] digitSum = new int[n + 1];

        // Build array of non-zero digits
        int m = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            nonZeroCnt[i + 1] = nonZeroCnt[i] + (d != 0 ? 1 : 0);
            digitSum[i + 1] = digitSum[i] + d;
            if (d != 0) m++;
        }

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Hash of concatenated non-zero digits
        long[] hash = new long[m + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                idx++;
                hash[idx] = (hash[idx - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = nonZeroCnt[l] + 1;
            int right = nonZeroCnt[r + 1];

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = (hash[right] - hash[left - 1] * pow10[len]) % MOD;
            if (x < 0) x += MOD;

            long sum = digitSum[r + 1] - digitSum[l];

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }
}