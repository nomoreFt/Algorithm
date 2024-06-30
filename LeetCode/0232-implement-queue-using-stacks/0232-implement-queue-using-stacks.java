class MyQueue {
    Deque<Integer> input;
    Deque<Integer> output;

    public MyQueue() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    //1,2,3 input
    //3,2,1 output    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */