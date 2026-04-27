import java.util.Arrays;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;

        // minDist[i] = minimum cost edge to connect point i to current MST
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        // visited[i] = whether point i is already in MST
        boolean[] visited = new boolean[n];

        // Start from point 0
        minDist[0] = 0;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            // Pick the unvisited node with minimum minDist
            int u = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < minValue) {
                    minValue = minDist[j];
                    u = j;
                }
            }

            // Add this node to MST
            visited[u] = true;
            totalCost += minDist[u];

            // Update distances for remaining nodes
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = manhattan(points[u], points[v]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }

        return totalCost;
    }

    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}