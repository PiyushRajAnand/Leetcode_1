class Solution {

    class Pair {
        int next;
        int weight;

        Pair(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        ArrayList<Pair>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, visited);

        return ans;
    }

    private void dfs(int node, ArrayList<Pair>[] graph, boolean[] visited) {

        visited[node] = true;

        for (Pair neighbour : graph[node]) {

            ans = Math.min(ans, neighbour.weight);

            if (!visited[neighbour.next]) {
                dfs(neighbour.next, graph, visited);
            }
        }
    }
}