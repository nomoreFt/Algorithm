import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        
        int[] degree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        while(n > 2){
            int size = q.size();
            n -= size;

            for(int i = 0; i < size; i++){
                int leaf = q.poll();
                for(int neighbor : graph.get(leaf)){
                    degree[neighbor]--;
                    if(degree[neighbor] == 1) q.offer(neighbor);
                }
            }           
        }

        return new ArrayList<>(q);
    }
}