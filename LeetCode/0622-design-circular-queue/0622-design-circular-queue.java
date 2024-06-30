class MyCircularQueue {
    int[] q;
    int head, tail, len;
    public MyCircularQueue(int k) {
        head = 0;
        tail = -1;
        len = 0;
        q = new int[k];        
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        this.tail = (this.tail + 1) % this.q.length;
        q[tail] = value;
        this.len++; 
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        this.head = (this.head + 1) % this.q.length;
        this.len--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return this.q[head];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return this.q[tail];
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */