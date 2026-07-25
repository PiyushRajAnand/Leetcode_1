class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int h:map.keySet()){
            if(set.contains(map.get(h))){
                return false;
            }
            set.add(map.get(h));
        }
        return true;
    }
}