class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str="123456789";
        List<Integer> list=new LinkedList<>();
        int k=1;
        for(int i=0;i+k<=str.length();i++){
            int n=Integer.parseInt(str.substring(i,i+k));
            if(n>=low && n<=high){
                list.add(n);
            }
            if(i+k==str.length()){
                k++;
                i=-1;
            }
        }
        return list;
    }
}