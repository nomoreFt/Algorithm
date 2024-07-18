import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int n : nums){
            m.put(n, m.getOrDefault(n,0) + 1);
        }

        int result = 0;
        int biggest = 0;
        for(Map.Entry e : m.entrySet()){
            if((int)e.getValue() > biggest){
                biggest = (int)e.getValue();
                result = (int)e.getKey();
            }
        }
        
        return result;
        
    }
}