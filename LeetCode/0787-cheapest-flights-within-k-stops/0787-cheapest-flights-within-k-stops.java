import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 그래프 생성
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        // 우선순위 큐 생성 (비용 기준으로 정렬)
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node(src, 0, 0));

        // 각 도시와 정류장 수에 따른 최소 비용을 기록
        int[][] minCost = new int[n][k + 2]; // [도시][정류장 수]
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        minCost[src][0] = 0;

        // BFS 탐색 시작
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.city == dst) return cur.cost;

            if (cur.stops > k) continue; // 정류장 수 초과

            // 현재 도시에서 이동 가능한 다른 도시 탐색
            for (Map.Entry<Integer, Integer> entry : graph.getOrDefault(cur.city, new HashMap<>()).entrySet()) {
                int nextCity = entry.getKey();
                int newCost = cur.cost + entry.getValue();

                // 해당 정류장 수로 가는 비용이 더 적을 때만 큐에 넣음
                if (newCost < minCost[nextCity][cur.stops + 1]) {
                    minCost[nextCity][cur.stops + 1] = newCost;
                    pq.offer(new Node(nextCity, newCost, cur.stops + 1));
                }
            }
        }

        return -1; // 경로를 찾을 수 없을 경우
    }

    static class Node {
        int city;  // 목적 도시
        int cost;  // 현재까지의 비용
        int stops; // 경유지 수

        Node(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }
}