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
        if (this.head != null){
            Node currentHead = this.head;
            node.setNext(currentHead);
            this.head = node;
        }else{
            this.head = node;
            this.tail = this.head;
        }
    }

    public void addToTail(Node node) throws NullPointerException{
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

    public void add(Node node) {
        if (this.head == null){
            addToHead(node);
        } else {
            addToTail(node);
            }
        }

    public String print() {
        String output = "<head> ";
        Node currentNode = this.head;
        for (Node i = currentNode; i == this.tail; i = currentNode.getNext()) {
            output += i.getData() + " ";
        }
        output += "<tail>";
        return output;
    }

    private void removeHead(){
        Node currentHead = this.head;
        if (currentHead.hasNext())
            this.head = currentHead.getNext();
        else
            this.head = null;
            this.tail = null;
    }



//    public Node remove(int idx) throws IllegalArgumentException{
//        if (idx < 0){
//            throw new IllegalArgumentException("index has to be positive") ;
//        }
//        if (idx == 0)
//            removeHead();
//        else {
//            Node currentNode = this.head;
//            for (int i = 0; i <= idx - 1; i++) {
//                currentNode = currentNode.getNext();
//                Node nodeToRemove = currentNode.getNext();
//                currentNode.setNext(nodeToRemove.getNext());
//            }
//        }
//    }
}
