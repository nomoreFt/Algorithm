import java.util.*;

public class Main{
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i = 0; i < 4; i++){
                int nX = node.x + dx[i];
                int nY = node.y + dy[i];
                if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                if(!visited[nX][nY] && graph[nX][nY] != 0){
                    graph[nX][nY] = graph[node.x][node.y]+1;
                    visited[nX][nY] = true;
                    q.offer(new Node(nX,nY));
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        
        visited = new boolean[n][m];
        graph = new int[n][m];
        
        for(int i = 0; i < n; i++){
            strs = sc.nextLine().split("");
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }

        bfs();
        System.out.println(graph[n-1][m-1]);
        

    }
}