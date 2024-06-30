package Programmers.kakaoblind_2021;

import java.io.*;
import java.util.ArrayList;

public class �űԾ��̵���õ {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String new_id = bf.readLine();
		
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
			String answer = "";
			new_id=new_id.toLowerCase();
			new_id=new_id.replaceAll("[^a-z0-9-_.]", "");
			new_id=new_id.replaceAll("\\.{2,}", "");
			new_id=new_id.replaceAll("^\\.","");
			new_id=new_id.replaceAll("[.]$","");
			if(new_id.isEmpty()) {
				new_id += "a";
			}
			if(new_id.length()>=16) {
				new_id = new_id.substring(0, 15);
				new_id = new_id.replaceAll("[.]$","");
			}
			if(new_id.length() <=2) {
				while(new_id.length()<3) {
					new_id += new_id.charAt(new_id.length()-1);
				}
			}
			return new_id;
	}
}
