class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                depth--;
                continue;
            }
            if (c != '(') continue;
            depth++;
            r=Math.max(r,depth);
        }
        return r;
    }
}