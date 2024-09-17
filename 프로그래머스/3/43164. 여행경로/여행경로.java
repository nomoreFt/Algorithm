import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(String[] ticket : tickets){
            graph.putIfAbsent(ticket[0], new PriorityQueue<String>());
            graph.get(ticket[0]).add(ticket[1]);    
        }
        
        dfs(graph, results, "ICN");
            
        return results.toArray(new String[0]);
    }
    
    public void dfs(Map<String, PriorityQueue<String>> graph, List<String> results, String from){
        while(graph.containsKey(from) && !graph.get(from).isEmpty()){
            dfs(graph, results, graph.get(from).poll());
        }
        
        results.add(0, from);
    }
}