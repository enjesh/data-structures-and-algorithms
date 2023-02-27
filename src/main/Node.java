package main;

public class Node {
    private String data;
    private Node next;

    public Node(String data){
        this.data = data;
        this.next = null;
    }

    public void setData(String data){
        this.data = data;
    }

    public void setNext(Node node) throws IllegalArgumentException{
        if (!this.equals(node))
            this.next = node;
        else
            throw new IllegalArgumentException("node cannot be linked to itself");
    }

    public String getData(){
        return this.data;
    }

    public Node getNext(){
        return this.next;
    }
}
