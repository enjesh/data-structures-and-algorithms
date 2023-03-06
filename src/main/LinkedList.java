package main;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void addToHead(Node node) {
        Node newHead = node;
        if (this.head != null){
            Node currentHead = this.head;
            newHead.setNext(currentHead);
            this.head = newHead;
    }else{
        this.head = newHead;
        this.tail = this.head;
        }
    }

    public void addToTail(Node node) throws NullPointerException{
        Node newTail = node;
        if (this.head == null){
            throw new NullPointerException("empty list cannot have a node!");
        }
        if (this.head.equals(this.tail)){
            this.head.setNext(node);
        }else {
            this.tail.setNext(node);
        }
        this.tail = node;

    }
}
