package codingTest.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Greedy_3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int length = strs.length;
		for(int i = 0; i < length; i++) {
			arr.add(Integer.parseInt(strs[i]));
		}
		int result = 0,group = 0;
		Collections.sort(arr);
		
		for(int i = 0; i < n; i++) {
			group++;
			if(group >= arr.get(i)) {
				group = 0;
				result++;
			}
		}
		System.out.println(result);
	}
}
