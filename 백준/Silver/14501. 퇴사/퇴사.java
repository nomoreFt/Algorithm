import java.util.*;

public class Main{
   private static class Day{
     int cost;
     int delay;
     public Day(int delay, int cost){
         this.cost = cost;
         this.delay = delay;
     }
   }
   static int max = Integer.MIN_VALUE;
   static int n;
   static ArrayList<Day> graph = new ArrayList<>();
   static boolean[] visited;
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);       
    n = sc.nextInt();
    visited = new boolean[n];
    for(int i = 0; i < n; i++){
        int delay = sc.nextInt();
        int cost = sc.nextInt();
        graph.add(new Day(delay,cost));
    }
   
    dfs(0,0);
    System.out.println(max);
   }
   static void dfs(int pay, int date) {
    if (date <= n) {
        max = Math.max(max, pay);
    }

    for (int i = date; i < n; i++) {
        dfs(pay + graph.get(i).cost,i + graph.get(i).delay);
    }

}
}