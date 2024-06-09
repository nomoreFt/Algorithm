class LRUCache {
    private class Node {
        int key, value;
        Node prev;
        Node next;
        public Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    private int capacity, size;
    private HashMap<Integer,Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node findOne = cache.get(key);
        if(findOne == null) return -1;
        
        removeNode(findOne);
        addToHead(findOne);
        return findOne.value;
    }
    
    public void removeNode(Node target){
        Node prev = target.prev;
        Node next = target.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addToHead(Node target){
        target.prev = head;
        target.next = head.next;
        head.next.prev = target;
        head.next = target;
        
    }
    
    public void put(int key, int value) {
        Node findOne = cache.get(key);
        if(findOne == null){
            //cache에 Put, head에 추가
            Node newNode = new Node(key,value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){
                removeTail();
                size--;
            }
        }else{
            Node updateCache = new Node(key,value);
            cache.put(key,  updateCache);
            removeNode(findOne);
            addToHead(updateCache);
        }
        
    }

    public void removeTail(){
        Node removeTarget = tail.prev;
        removeNode(removeTarget);
        cache.remove(removeTarget.key); // 캐시에서도 제거
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */