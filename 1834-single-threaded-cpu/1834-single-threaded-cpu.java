class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[] sequence = new int[n];

        // Store: [enqueueTime, processingTime, originalIndex]
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort according to enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Store index in arr
        // Shortest processing time -> smallest original index
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (arr[a][1] == arr[b][1]) {
                return Integer.compare(arr[a][2], arr[b][2]);
            }
            return Integer.compare(arr[a][1], arr[b][1]);
        });

        long currentTime = 0;
        int i = 0;
        int index = 0;

        while (i < n || !pq.isEmpty()) {

            // If no task is available, jump to next task's enqueue time
            if (pq.isEmpty()) {
                currentTime = Math.max(currentTime, arr[i][0]);
            }

            // Add all available tasks
            while (i < n && arr[i][0] <= currentTime) {
                pq.offer(i);
                i++;
            }

            // Pick shortest processing time
            int task = pq.poll();

            // Store ORIGINAL index
            sequence[index++] = arr[task][2];

            // Process task
            currentTime += arr[task][1];
        }

        return sequence;
    }
}