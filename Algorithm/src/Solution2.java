import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution2 {
	public static void main(String[] args) {
		System.out.println(solution(2,3,3,2));
	}
	static int result = 0;
	static HashSet<String> set = new HashSet<String>();
    public static int solution(int A, int B, int C, int D) {
    	int[] arr = {A,B,C,D};
    	boolean[] visited = new boolean[4];
    	int[] output = new int[4];
    	Arrays.sort(arr);
    	permutation(arr,0,visited,output);
    	return set.size();
    }
    public static void permutation(int[] arr, int depth, boolean[] visited, int[] output){
    	if(depth == 4) {
			/*
			 * for(int i = 0; i < 4; i++) {
			 * 
			 * System.out.print(output[i]); }
			 */
    		validationTime(output);
    		return;
    	}
    	for(int i = 0; i < 4; i++) {
    		if(visited[i]) continue;
    		
    		visited[i] = true;
    		output[depth] = arr[i];
    		permutation(arr,depth+1,visited,output);
    		visited[i] = false;
    	}
    }
    public static void validationTime(int[] output) {
    		if(output[0]>3) return;
    		if(output[2]>5) return;
    		String str = null;
    		for(int i = 0 ; i < 4; i++) {
    			str += String.valueOf(output[i]);
    		}
    		if(output[0]==1 && output[1] < 10 ) {
    			set.add(str);
    		}
    		else if(output[0]==2 && output[1]<4) {
    			set.add(str);
    		}
    		
    }
}
