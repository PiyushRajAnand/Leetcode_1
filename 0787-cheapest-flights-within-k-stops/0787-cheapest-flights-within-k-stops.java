
import java.util.*;

class GraphNode {
    int index;
    ArrayList<int[]> arr;

    GraphNode(int index) {
        this.index = index;
        this.arr = new ArrayList<>();
    }
}

class Solution {
    public int findCheapestPrice(
        int n, int[][] flights, int src, int dst, int k
    ) {
        GraphNode[] stop = new GraphNode[n];

        for (int i = 0; i < n; i++) {
            stop[i] = new GraphNode(i);
        }

        for (int[] flight : flights) {
            stop[flight[0]].arr.add(
                new int[]{flight[1], flight[2]}
            );
        }

        // best[city][flightsUsed] = minimum cost
        int[][] best = new int[n][k + 2];

        for (int[] row : best) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        best[src][0] = 0;
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int city = curr[1];
            int used = curr[2];

            if (cost != best[city][used]) {
                continue;
            }

            if (city == dst) {
                return cost;
            }

            if (used == k + 1) {
                continue;
            }

            for (int[] edge : stop[city].arr) {
                int next = edge[0];
                int newCost = cost + edge[1];
                int newUsed = used + 1;

                if (newCost < best[next][newUsed]) {
                    best[next][newUsed] = newCost;
                    pq.offer(new int[]{
                        newCost, next, newUsed
                    });
                }
            }
        }

        return -1;
    }
}
