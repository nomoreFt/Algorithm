import java.util.*;

class Solution {
    public int[] solution(int start, int end) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = start; i <= end; i++){
            arr.add(i);
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}