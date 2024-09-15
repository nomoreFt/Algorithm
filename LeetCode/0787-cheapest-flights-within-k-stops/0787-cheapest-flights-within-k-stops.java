import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer,Integer>> graph = new HashMap<>();
        for(int[] flight : flights){
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1],flight[2]);
        }

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Node(src,0,0));
        
        int[][] minCost = new int[n][k + 2];
        for(int i = 0; i < n; i++){
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        minCost[src][0] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.city == dst) return cur.cost;
            if(cur.stops > k) continue;
            
            for(Map.Entry<Integer, Integer> entry 
            : graph.getOrDefault(cur.city, new HashMap<>()).entrySet()){
                int nextCity = entry.getKey();
                int newCost = cur.cost + entry.getValue();

                if(newCost < minCost[nextCity][cur.stops + 1]){
                    minCost[nextCity][cur.stops + 1] = newCost;
                    pq.offer(new Node(nextCity, newCost, cur.stops + 1));
                }
            }
        }

        return -1;
    }
    
    static class Node{
        int city;
        int cost;
        int stops;
        Node(int city, int cost, int stops){
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }
}