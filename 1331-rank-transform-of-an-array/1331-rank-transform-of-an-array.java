class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0){
            return new int[0];
        }
        int m[]=arr.clone();
        Arrays.sort(arr);
        HashMap<Integer,Integer> hm=new HashMap<>();
        int rank=1;
        hm.put(arr[0],1);
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==arr[i]){
                continue;
            }
            rank++;
            hm.put(arr[i],rank);
            
        }
        for(int i=0;i<m.length;i++){
            arr[i]=hm.get(m[i]);
        }
        return arr;
    }
}