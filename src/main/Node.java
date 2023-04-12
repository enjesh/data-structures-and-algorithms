package main;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setNext(Node<T> node) throws IllegalArgumentException{
        if (!this.equals(node))
            this.next = node;
        else
            throw new IllegalArgumentException("node cannot be linked to itself");
    }

    public boolean hasNext(){
        return !(this.getNext() == null);
    }

    public T getData(){
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

