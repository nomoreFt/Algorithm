class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> table = new HashMap<>() {{
            put(')','(');
            put('}','{');
            put(']','[');
        }};

        //stack에 시작 브라킷 넣으면서 진행, stack.peek()에 닫힌 브라킷 상대역이 아니면 false
        int len = s.length();
        for(int i = 0; i < len; i++){
            char now = s.charAt(i);
            if(!table.containsKey(now)){//열린 브래킷이면 무조건 담음
                stack.push(now);
            }else{//끝맺음 브라킷
                if(stack.isEmpty()) return false;
                if(table.get(now) != stack.peek()) return false;
                //같은 짝궁이면 pop
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}