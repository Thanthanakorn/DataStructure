public class LinkedList <T>{

    private class Node{
        T data;
        Node next,prev;

        public Node(){
            this.data=null;
            this.next=null;
            this.prev=null;
        }

        public Node(Node prev, T data, Node next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel;

    private int size;

    public LinkedList() {
        size = 0;
    }

    public LinkedList(T data) {
        sentinel = new Node();
        sentinel.next = new Node(sentinel, data, sentinel);
        sentinel.prev = sentinel.next;
        size++;
    }

    public LinkedList(LinkedList<T> other){
        this.sentinel = new Node();
        this.size = 0;
        Node current = other.sentinel.next;
        while(current.data != null){
            this.addLast(current.data);
            current = current.next;
        }
    }

    public int size(){
        return size;
    }

    public void Start(T data){
        sentinel = new Node();
        sentinel.next = new Node(sentinel, data, sentinel);
        sentinel.prev = sentinel.next;
        size++;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item){
        if (this.isEmpty()){
            Start(item);
            return;
        }
        Node temp = sentinel.next;
        sentinel.next = new Node(sentinel, item, temp);
        temp.prev = sentinel.next;
        size++;
    }
    // Adds an item of type T to the back of the deque.
    public void addLast(T item){
        if (this.isEmpty()){
            Start(item);
            return;
        }
        Node temp = sentinel.prev;
        sentinel.prev = new Node(temp, item, sentinel);
        temp.next = sentinel.prev;
        size++;
    }
    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        return size == 0;
    }
    // Returns a string showing the items in the deque from first to last, // separated by a space.
    public String toString(){
        Node current = sentinel.next;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(current.next.data != null){
            String objectToString = current.data.toString();
            sb.append(objectToString).append(", ");
            current = current.next;
        }
        sb.append(current.data.toString());
        sb.append("]");
        return sb.toString();
    }
    // Removes and returns the item at the front of the deque. // If no such item exists, returns null.
    public T removeFirst(){
        if (this.isEmpty()){
            return null;
        }
        T item = sentinel.next.data;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return item;
    }
    // Removes and returns the item at the back of the deque. // If no such item exists, returns null.
    public T removeLast(){
        if (this.isEmpty()){
            return null;
        }
        T item = sentinel.prev.data;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }
    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        Node current = sentinel.next;
        while (index != 0){
            current = current.next;
            index--;
        }
        return current.data;
    }

}
