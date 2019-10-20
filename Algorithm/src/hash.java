import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class hash {

	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String playerName : participant) {
        	map.put(playerName, map.getOrDefault(playerName, 0) + 1);
        }
        

        for(String playerName : completion) {
        	map.put(playerName, map.get(playerName)-1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
        	if(entry.getValue() != 0) answer = entry.getKey();
        }
        map.entrySet().forEach(entry -> System.out.println(entry.getKey()));
        return answer;
		/*
		 * HashMap<String, Integer> hm = new HashMap<>(); for (String player :
		 * participant) hm.put(player, hm.getOrDefault(player, 0) + 1); for (String
		 * player : completion) hm.put(player, hm.get(player) - 1);
		 * 
		 * 
		 * 
		 * for (Map.Entry<String, Integer> entry : hm.entrySet()) {
		 * if(entry.getValue()!= 0) { answer = entry.getKey(); } }
		 * 
		 * 
		 * for (String key : hm.keySet()) { if (hm.get(key) != 0){ answer = key; } }
		 * return answer;
		 */
    }
	
	public static void main(String[] args) {
		
		
		
		String participant[] = {"leo", "kiki", "eden"};
	String completion[] = {"eden","kiki"};
	String answer = solution(participant,completion);
	System.out.println(answer);
	}
}
