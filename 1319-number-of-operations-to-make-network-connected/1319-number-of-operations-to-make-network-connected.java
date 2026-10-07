class DSU{
    int parent[];
    int rank[];
    int component;
    public DSU(int n){
        this.parent=new int[n];
        this.rank=new int[n];
        this.component=0;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x]);
    }
    public void union(int[] parent,int[] rank,int[][] components,int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX==rootY) return;
        if(rootX<rootY){
            parent[rootX]=rootY;
        }else if(rootX>rootY){
            parent[rootY]=rootX;
        }else{
            parent[rootY]=rootX;
            rank[rootX]++;
        }
    }
    public int ans(int n,int[][] components){
        
        for(int i=0;i<components.length;i++){
            int u=components[i][0];
            int v=components[i][1];
            union(parent,rank,components,u,v);
        }
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                component++;
            }
        }
        if(n-1>components.length) return -1;
        return component-1;

    }
}




class Solution {
    public int makeConnected(int n, int[][] connections) {
        DSU d=new DSU(n);
        return d.ans(n,connections);
    }
}