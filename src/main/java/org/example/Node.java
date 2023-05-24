package org.example;

public class Node<T> {
    private T data;
    private Node<T> next;

    public T getData() {
        return data;
    }

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) throws IllegalArgumentException{
        if (next == this){
            throw new IllegalArgumentException("Node cannot point to itself");
        }
        else
            this.next = next;
    }

    public boolean hasNext(){
        return this.next != null;

    }

    @Override
    public String toString() {
        return "Node{" + this.data + "}";
    }
}
