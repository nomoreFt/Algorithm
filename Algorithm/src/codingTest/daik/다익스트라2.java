package codingTest.daik;

import java.util.*;
class Node {
	private int index;
	private int distance;
	
	public Node(int index, int distance){
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
public class 다익스트라2 {

	public static final int INF = Integer.MAX_VALUE;
	//노드의 개수 n, 간선개수 m, 시작 노드 번호 Start
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static boolean[] visited = new boolean[100001];
	public static int[] d = new int[100001];
	


public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	n = sc.nextInt();
	m = sc.nextInt();
	start = sc.nextInt();
	
	for(int i = 0; i <= n; i++) {
		graph.add(new ArrayList<Node>());
	}
	
	for(int i = 0; i < m; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		graph.get(a).add(new Node(b,c));
	}
	
	Arrays.fill(d,  INF);
	
	dijkstra(start);
	
}


//start 노드부터 도달 최소거리
public static void dijkstra(int start) {
	//시작노드 초기화
	d[start] = 0; //자기 자신 가치는 0
	visited[start] = true;
	for(int j = 0 ; j < graph.get(start).size(); j++) {
		d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
	}
	
	
	//시작 노드 제외한 전체 n-1개에 대해 반복
	for(int i = 0; i < n-1; i++) {
		int now = getSmallestNode();
		visited[now] = true;
		//현재 노드와 연결된 다른 노드를 확인
		for(int j = 0; j < graph.get(now).size();j++) {
			int cost = d[now] + graph.get(now).get(j).getDistance();
			
			if(cost < d[graph.get(now).get(j).getIndex()])
		}
	}
	
}


private static int getSmallestNode() {
	int min_value = INF;
	int index = 0;
	
	for(int i = 1; i<= n; i++) {
		if(d[i] < min_value && !visited[i]) {
			min_value = d[i];
			index = i;
		}
	}
	return index;
}


}
