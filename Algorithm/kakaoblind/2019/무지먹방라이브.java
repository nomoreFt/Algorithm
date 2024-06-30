package Programmers.kakaoblind_2019;

import java.util.ArrayList;
import java.util.List;

public class 무지먹방라이브 {

	public static void main(String[] args) {
		int[] food_times = {3, 5, 1 , 6, 5, 3};
		int k = 20;
		System.out.println(solution(food_times, k));
	}
	    static class Food {
	        int time;
	        int idx;
	        Food (int t, int i){
	            time = t;
	            idx = i;
	        }
	    };
	    
	    public static int solution(int[] food_times, long k) {
	        int N = food_times.length;
	        List<Food> foodList = new ArrayList<Food>();
	        for(int i = 0 ; i < N; i++){
	            foodList.add(new Food(i+1,food_times[i]));
	        }
	        foodList.sort((a, b) -> a.time - b.time);
	        
	        int pretime = 0;
	        int width = N;
	        for(int j = 0 ; j < N; j++){
	            int height = foodList.get(j).time - pretime;
	            if(height == 0) {
	                width--;
	                continue;
	            }else{
	                int spend = width * height;
	                if(spend <= k){
	                    k -= spend;
	                    width --;
	                    pretime = foodList.get(j).time;
	                }else if(spend == k){
	                    return -1;
	                }else{
	                   k %= width;
	                   List<Food> subList = foodList.subList(j, N);
	                   subList.sort((a, b) -> a.idx - b.idx);
	                   return subList.get((int) k).idx;
	                }
	            }
	        }
	    return -1;
	    }
	}
