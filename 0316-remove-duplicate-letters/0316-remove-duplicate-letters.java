class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++){
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] usedChar = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < len; i++){
            char target = s.charAt(i);
            
            if(usedChar[target - 'a']) continue; //이미 사용중이라면 스킵
            
            while(!stack.isEmpty() 
            && stack.peek() > target 
            && lastIdx[stack.peek() - 'a'] > i ){
            usedChar[stack.pop() - 'a'] = false;
            }
                                    
            stack.push(target);//stack에 넣고 사용중 표시
            usedChar[target - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        return sb.reverse().toString();
        
    }
}