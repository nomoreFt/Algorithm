import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
            if (m.get(n) > nums.length / 2) {
                return n;
            }
        }
        
        return -1; 
    }
}