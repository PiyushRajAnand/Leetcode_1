class Solution {
   public int maxArea(int[] height) {
    if(height == null || height.length == 0) return 0;
    int water = 0, l = 0, r = height.length-1;
    while(l < r) {
        int h = Math.min(height[l], height[r]);
        water = Math.max(water, (r - l) * h);
        while(l < r && height[l] <= h) l++;
        while(l < r && height[r] <= h) r--;
    }
    return water;
}
}
