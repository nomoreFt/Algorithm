package codingTest.implement;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class implement_4 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		char[] chs = str.toCharArray();
		int ans = 0;
		ArrayList<String> arr = new ArrayList<String>();
		String ansStr = null;
		for(char ch : chs) {
			if(Character.isDigit(ch))  ans += ch-'0';
			if(Character.isLetter(ch))	arr.add(ch+""); 
		}
		
		Collections.sort(arr);
		int size = arr.size();
		str = "";
		for(int i = 0 ; i < size; i++) {
			str += arr.get(i);
		}
		System.out.println(str + ans);
	}
}
