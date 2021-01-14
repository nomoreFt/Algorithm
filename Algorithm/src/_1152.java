

import java.io.*;
import java.util.StringTokenizer;

public class _1152 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		 * System.out.println(st.countTokens());
		 */
		int cnt = 0;
		String str[] = bf.readLine().split(" ");
		for(String strt : str) {
			if(strt.trim().length()>0) cnt++;
		}
System.out.println(cnt);
	}
}
