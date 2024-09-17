import java.util.*;

class Solution {
    static int[] dX = {-1,1,0,0};
    static int[] dY = {0,0,-1,1};
    public int solution(int[][] givenMaps) {
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Node(0,0,1));
        int xSize = givenMaps.length;
        int ySize = givenMaps[0].length;
        
        int[][] minCost = new int[xSize][ySize];
        for(int i = 0; i < xSize; i++){
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.x == xSize -1 && cur.y == ySize -1) return cur.cost;
            
            for(int i = 0; i < 4; i++){
                int nX = dX[i] + cur.x;
                int nY = dY[i] + cur.y;
                int newCost = cur.cost + 1;
                
                if(nX < 0 || nX >= xSize || nY < 0 || nY >= ySize) continue;    
                if(givenMaps[nX][nY] == 0) continue;
                if(newCost >= minCost[nX][nY]) continue;
                
                minCost[nX][nY] = newCost;
                pq.add(new Node(nX,nY,newCost));
                
            }
            
        }
        
    
        return -1;
    }
    static class Node{
        int x;
        int y;
        int cost;
        
        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}