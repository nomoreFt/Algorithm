import java.util.*;

class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
	public static int N,L,R;
	public static int[][] graph = new int[51][51];
	public static int[][] union = new int[51][51];
	  public static int[] dx = {-1, 0, 1, 0};
	    public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		//초기셋팅
		for(int i = 0 ; i <N; i++) {
			for (int j = 0 ; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		int totalCnt = 0;
		while(true) {
			int index = 0;
			
			for(int i = 0 ; i < N; i++) {
				Arrays.fill(union[i],-1);
			}
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(union[i][j] == -1) {
						bfs(i,j,index);
						index += 1;
					}
				}
			}
			
			if(index == N * N) break;
			totalCnt += 1;
			
		}
		System.out.println(totalCnt);
	}
	public static void bfs(int x, int y, int index) {
		ArrayList<Position> united = new ArrayList<>();
		united.add(new Position(x,y));
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x,y));
		union[x][y] = index;
		int sum = graph[x][y];
		int count = 1;
		while(!q.isEmpty()) {
			Position pos = q.poll();
			x = pos.x;
			y = pos.y;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(union[nx][ny] == -1) {
					int gap = Math.abs(graph[pos.x][pos.y] - graph[nx][ny]);
					if(gap >= L && gap <= R) {
						union[nx][ny] = index;
						q.offer(new Position(nx,ny));
						united.add(new Position(nx,ny));
						sum += graph[nx][ny];
						count += 1;
				}
				}
				
			}
		}
		for(int i = 0 ; i < united.size(); i++) {
			Position pos = united.get(i);
			graph[pos.x][pos.y] = sum/count;
		}
	}

}
