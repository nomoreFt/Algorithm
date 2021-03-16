import java.util.Arrays;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static void main(String[] args) {
    	String[] A= {"Oncology","Oncology","Oncology","Neurology"};
    	System.out.println(solution(A));
	}
    public static int solution(String[] A) {
    	int[] arr = new int[5];
    	for(String str : A) {
    		if(str.length() == "Oncology".length()) arr[0]++;
    		else if(str.length() == "Neurology".length()) arr[1]++;
    		else if(str.length() == "Cardiology".length()) arr[2]++;
    		else if(str.length() == "Gynaecology".length()) arr[3]++;
    		else arr[4]++;
    	}
    	Arrays.sort(arr);
    	return arr[arr.length-1];
    }
}
