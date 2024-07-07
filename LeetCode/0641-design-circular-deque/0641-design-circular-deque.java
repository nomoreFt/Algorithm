class MyCircularDeque {
    int[] q;
    int front;
    int tail;
    int len;

    public MyCircularDeque(int k) {
        q = new int[k];
        front = 0;
        tail = -1;
        len = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + q.length) % q.length;
        q[front] = value;
        if (len == 0) {
            tail = front; // 첫 번째 원소가 삽입되면 tail도 front와 같아야 함
        }
        len++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        tail = (tail + 1) % q.length;
        q[tail] = value;
        len++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % q.length;
        len--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + q.length) % q.length;
        len--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return q[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return q[tail];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == q.length;
    }
}
