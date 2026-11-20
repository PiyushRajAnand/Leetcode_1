class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            int flag=1;
            int num=i;
            while(num>0){
                int r=(num%10);
                
                if(r==0 || i%r!=0){
                    flag=0;
                }
                num/=10;
            }
            if(flag==1){
                list.add(i);
            }
        }
        return list;
    }
}