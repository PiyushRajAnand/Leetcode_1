class Solution {
    public int[] constructRectangle(int area) {
        int w=(int)Math.sqrt(area);
        while(area%w!=0){
            w--; //to find w as small as possible 
        }
        int l=area/w;
        return new int[]{l,w};
    }
}