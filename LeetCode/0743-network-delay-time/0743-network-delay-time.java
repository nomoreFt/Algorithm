import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //출발지, 도착지(도착지, 도달거리)
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] time : times){
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1],time[2]);
        }

        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k,0));
        
        Map<Integer, Integer> dist = new HashMap<>();

        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> cur = pq.poll();
            int targetV = cur.getKey();
            int targetV_dist = cur.getValue();

            if(!dist.containsKey(targetV)){
                dist.put(targetV, targetV_dist);
                if(graph.containsKey(targetV)){
                   for(Map.Entry<Integer, Integer> v : graph.get(targetV).entrySet()){
                    int alt = targetV_dist + v.getValue();
                    pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                   } 
                }
            }
        }

        if(dist.size() == n) return Collections.max(dist.values());
        return -1;
        

    }
}
/**
pq로 도달거리가 짧은 간선을 가진 정점을 우선으로 줄세워 먼저 뽑아내고,
그 정점들을 기준으로 먼저 dist를 채워 뒤떨어지는 도달거리를 가진 정점을 쳐낸다.
 */