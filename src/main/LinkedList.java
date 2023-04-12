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
        if (this.tail == null){
            throw new NullPointerException("empty list cannot have a node!");
        }
            this.tail.setNext(node);
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
        for (Node i = this.head; i != null; i = i.getNext()) {
            output += i.getData() + " ";
        }
        output += "<tail>";
        return output;
    }

    private void removeHead(){
        Node currentHead = this.head;
        if (currentHead.hasNext())
            this.head = currentHead.getNext();
        else {
            this.head = null;
            this.tail = null;
        }
    }


    public void remove(int i) {
        if (i == 0)
            removeHead();
        else {
            Node preNodeToRemove = this.head;
            for (int j = 0; j < i - 1; j++) {
                preNodeToRemove = preNodeToRemove.getNext();
            }
            Node nodeToRemove = preNodeToRemove.getNext();
            /*check if the node to remove is the tail*/
            if (nodeToRemove.getNext() == null){
                preNodeToRemove.setNext(null);
                this.tail = preNodeToRemove;
            }
            else {
                preNodeToRemove.setNext(nodeToRemove.getNext());
            }
        }
    }

    public void reverse() {
        Node start = this.head.getNext();
        this.head.setNext(null);
        Node currentTail = this.tail;
        for (Node i = start; i != currentTail ; ) {
            Node next = i.getNext();
            this.addToHead(i);
            i = next;
        }
        this.addToHead(currentTail);
    }
}
