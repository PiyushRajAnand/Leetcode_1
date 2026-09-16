class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead=new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000")){
            return -1;
        }
        Queue<Pair> queue=new ArrayDeque<>();
        Set<String> vis=new HashSet<>();
        queue.offer(new Pair(0,"0000"));
        vis.add("0000");
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            String str=pair.str;
            int step=pair.step;
            if(str.equals(target)){
                return step;
            }
            for(int i=0;i<4;i++){
                for(int j:new int[]{-1,1}){
                    char []ch=str.toCharArray();
                    int c=(ch[i]-'0'+j+10)%10;
                    ch[i]=(char)(c+'0');
                    String newStr=String.valueOf(ch);

                    if(!vis.contains(newStr) && !dead.contains(newStr)){
                        vis.add(newStr);
                        queue.offer(new Pair(step+1,newStr));
                        // System.out.print(newStr);
                    }
                }
            }
        } 
        return -1;
    }
}

class Pair{
    int step;
    String str;
    Pair(int step,String str){
        this.step=step;
        this.str=str;
    }
}