package Programmers.kakaoblind_2019;

import java.util.LinkedList;
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
	    
	    public static  int solution(int[] food_times, long k) {
	        List<Food> foods = new LinkedList<Food>();
	        int n = food_times.length;
	        for(int i = 0 ; i < n; i++){
	            foods.add(new Food(food_times[i], i+1));
	        }    
	            foods.sort((a, b) -> a.time - b.time);
	        
	        int pretime = 0;
	        int i = 0;
	        for(Food f : foods){
	            long diff = f.time - pretime;
	            if(diff != 0){
	                long spend = diff * n;
	                if(spend <= k){
	                    k -= spend;
	                    pretime = f.time;
	                }else {
	                    k %= n;
	                    foods.subList(i, food_times.length).sort((a, b) -> a.idx - b.idx);
	                    return foods.get(i+(int)k).idx;
	                }
	            }
	            i++;
	            n--;
	        }
	        
	        
	        return -1;
	    }
	}
