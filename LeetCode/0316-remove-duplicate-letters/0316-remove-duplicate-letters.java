class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int[] lastIdx = new int[26];
        boolean[] used = new boolean[26];
        int len = s.length();
        //lastIdx 측정
        for(int i = 0; i < len; i++){
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        
        //문장 돌면서 stack push, 뒤에 lastIdx 가 추가적으로 있거나 변곡점 있으면 pop
        for(int i = 0; i < len; i++){
            char target = s.charAt(i);
            if(used[target - 'a']) continue; //연속으로 들어오는것 배제
            while(!stack.isEmpty()
            && stack.peek() > target
            && lastIdx[stack.peek() - 'a'] > i){
                char temp = stack.pop();
                used[temp - 'a'] = false;
            } 

            stack.push(target);
            used[target - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }


        return sb.reverse().toString();
        
    }
}





