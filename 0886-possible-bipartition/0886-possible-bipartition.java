class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Step 1: TRANSLATE the problem into a graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] pair : dislikes) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]); // undirected edge
        }
        
        // Step 2: Standard bipartite check (identical to LC 785)
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        
        for (int i = 1; i <= n; i++) { // people numbered 1 to n
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 0;
                
                while (!queue.isEmpty()) {
                    int person = queue.poll();
                    
                    for (int disliked : graph.get(person)) {
                        if (color[disliked] == -1) {
                            color[disliked] = 1 - color[person];
                            queue.offer(disliked);
                        } else if (color[disliked] == color[person]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}