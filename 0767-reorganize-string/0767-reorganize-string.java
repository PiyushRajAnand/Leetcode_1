class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        StringBuilder str=new StringBuilder();
        for(char c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        pq.addAll(hm.keySet());
        while(pq.size()>1){
            char c1=pq.poll();
            char c2=pq.poll();
            str.append(c1);
            str.append(c2);
            hm.put(c1,hm.getOrDefault(c1,0)-1);
            hm.put(c2,hm.getOrDefault(c2,0)-1);
            if(hm.get(c1)>0){pq.offer(c1);}
            if(hm.get(c2)>0){pq.offer(c2);}
        }
        if(pq.size()==1){
            char c=pq.poll();
            if(hm.get(c)==1){
                str.append(c);
            }else{
                return "";
            }
        }
        return str.toString();
    }
}