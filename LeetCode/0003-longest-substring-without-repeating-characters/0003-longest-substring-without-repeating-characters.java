class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> used = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        
        for(char c : s.toCharArray()){
            if(left <= used.getOrDefault(c,-1)){
                left = used.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            
            used.put(c, right);
            right++;
        }
        return maxLength;
    }
}