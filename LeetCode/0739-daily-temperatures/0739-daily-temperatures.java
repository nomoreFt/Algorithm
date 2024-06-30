class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() 
            && temperatures[i] > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);    
        }
        return result;
    }
}