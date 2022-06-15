import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String[] arr : clothes){
            String key = arr[1];
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.put(key,map.get(key)+1);
            }
        }
        
        
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()){
            answer *= it.next().intValue()+1;
            
        }
        return answer-1;
    }
}