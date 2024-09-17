class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(results, graph, "JFK");

        return results;
    }

    public void dfs(List<String> results, Map<String, PriorityQueue<String>> graph, String from){
        
        while(graph.containsKey(from) && !graph.get(from).isEmpty()){
            dfs(results, graph, graph.get(from).poll());
        }
        
        results.add(0, from);
    }
}