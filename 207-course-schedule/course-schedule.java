import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list: from prerequisite -> list of courses depending on it
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        // build graph and indegree array
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            graph.get(pre).add(course);
            inDegree[course]++;
        }

        // queue of all courses with no prerequisites
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int taken = 0;

        // standard BFS topological sort
        while (!q.isEmpty()) {
            int cur = q.poll();
            taken++;

            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // if we could take all courses, no cycle exists
        return taken == numCourses;
    }
}