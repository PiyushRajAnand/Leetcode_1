class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            area=Math.max((right-left)*Math.min(height[left],height[right]),area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }
}