import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        Map<Character, Character> table = new HashMap<>() {{
            put(')','(');
            put('}','{');
            put(']','[');
        }};

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!table.containsKey(c)){
                stack.push(c);
            } else {
                if(stack.isEmpty() || table.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}