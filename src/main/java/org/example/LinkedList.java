package org.example;

public class LinkedList <T>{
    private Node<T> head;

    public Node<T> getHead() {
        return this.head;
    }

    public void addToHead(Node<T> newHead){
        if (this.head != null)
            newHead.setNext(this.head);
        this.head = newHead;
    }

    public void addToTail(Node<T> newTail){
        if (this.head == null)
            this.head = newTail;
        else{
            Node<T> currentNode = this.head;
            while (currentNode.hasNext()) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newTail);
        }
    }

}
