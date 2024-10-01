import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leafs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1) leafs.add(i);
        }

        while(n > 2){
            n -= leafs.size();
            List<Integer> newLeafs = new ArrayList<>();
            for(int leaf : leafs){
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Object) leaf);
                if(graph.get(neighbor).size() == 1) newLeafs.add(neighbor);
            }
            
            leafs = newLeafs;
        }

        return leafs;
    }
}