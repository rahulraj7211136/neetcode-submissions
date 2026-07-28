class LRUCache {
    class Node{
        public int key;
        public int val;
        public Node next;
        public Node prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> mp;
    int capacity;

    public LRUCache(int capacity) {
        this.head = new Node(-1,0);
        this.tail = new Node(-1,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        mp = new HashMap<>();
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) {
            return -1;
        }
        Node node = mp.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            Node node = mp.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        insert(node);
        mp.put(key, node);
        if(mp.size() > capacity) {
            Node rem = tail.prev;
            remove(rem);
            mp.remove(rem.key);
        }
    }
}
