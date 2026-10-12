class GraphNode {
    int index;
    int distance;
    ArrayList<int[]> neighbours;

    GraphNode(int index) {
        this.index = index;
        this.distance = Integer.MAX_VALUE;
        this.neighbours = new ArrayList<>();
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        GraphNode[] graph = new GraphNode[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new GraphNode(i);
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph[u].neighbours.add(new int[]{v, w});
        }
        graph[k].distance = 0;
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.distance, b.distance)
        );
        pq.offer(graph[k]);
        while (!pq.isEmpty()) {
            GraphNode current = pq.poll();
            for (int[] neighbour : current.neighbours) {
                int nextNode = neighbour[0];
                int weight = neighbour[1];
                int newDistance = current.distance + weight;
                if (newDistance < graph[nextNode].distance) {
                    graph[nextNode].distance = newDistance;
                    pq.offer(graph[nextNode]);
                }
            }
        }
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (graph[i].distance == Integer.MAX_VALUE) {
                return -1;
            }
            maxDistance = Math.max(
                maxDistance, graph[i].distance
            );
        }
        return maxDistance;
    }
}
