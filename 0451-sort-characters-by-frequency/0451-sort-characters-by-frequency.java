class Solution {
    public String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> hm=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        pq.addAll(hm.keySet());
        while(!pq.isEmpty()){
            char c=pq.poll();
            int f=hm.get(c);
            while(f>0){
                sb.append(c);
                f--;
            }
        }
        return sb.toString();
    }
}