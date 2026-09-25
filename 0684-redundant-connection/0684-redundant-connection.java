class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Union u=new Union(n+1);
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            if(!u.isRedundant(a,b)){
                return new int[]{a,b};
            }
        }
        return new int[]{};
    }
}
class Union{
    int[] parent;
    int rank[];
    Union(int n){
        this.parent=new int[n];
        this.rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int x){
        if(parent[x]!=x){
             parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    public boolean isRedundant(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX==rootY){
            return false;
        }
        parent[rootY]=rootX;
        return true;
    }
}