import java.util.*;
import java.io.*;

class Position{
	int x;
	int y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Combination2{
	int n;
	int r;
	int[] now;
	ArrayList<ArrayList<Position>> result;
	
	public Combination2(int n, int r) {
		this.n = n;
		this.r = r;
		now = new int[r];
		result = new ArrayList<ArrayList<Position>>();
	}
	
	public void comb(ArrayList<Position> arr, int depth, int index, int target){
		if(depth == r) {
			ArrayList<Position> temp = new ArrayList<>();
			for(int i = 0; i < now.length; i++) {
				temp.add(arr.get(now[i]));
			}
			result.add(temp);
			return;
		}
		if(target == n) return;
		now[index] = target;
		comb(arr, depth+1, index+1, target+1);
		comb(arr, depth, index, target+1);
	}
}
public class Main {
	public static int[][] graph;
	public static ArrayList<Position> chics = new ArrayList<>();
	public static ArrayList<Position> houses = new ArrayList<>();
	public static ArrayList<ArrayList<Position>> arr = new ArrayList<>();
	public static int N,M;
	public static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		graph = new int[N][N];
		for(int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(strs[j]);
				if(graph[i][j] == 2) chics.add(new Position(i,j));
				if(graph[i][j] == 1) houses.add(new Position(i,j));
			}
		}
		
		Combination2 combination = new Combination2(chics.size(), M);
		combination.comb(chics, 0, 0, 0);
		arr = combination.result;
		
		for(int i = 0; i < arr.size(); i++) {
			ArrayList<Position> tail = arr.get(i);
			int sum = 0;
			for(int j = 0; j < houses.size(); j++) {//집의 개수만큼 반복
				Position house = houses.get(j);
				int chicDistance = (int) 1e9;
				for(int k = 0; k < tail.size(); k++) {//k번째 집과 모든 치킨집간의 치킨거리를 비교하여 계산
					Position chicken = tail.get(k);
					int temp = getDistance(chicken,house);
					chicDistance = Math.min(chicDistance,temp);
				}
				sum += chicDistance;
			}
			answer = Math.min(answer, sum);
		}
		System.out.print(answer);
	}
	
	public static int getDistance(Position chicken, Position house) {
		int a = Math.abs(chicken.x - house.x);
		int b = Math.abs(chicken.y - house.y);
		return a+b;
	}
}
