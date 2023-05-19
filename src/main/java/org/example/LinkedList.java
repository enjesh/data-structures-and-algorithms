package org.example;

/**
 * Implementation of Linkedlist that uses Node class
 * Keeping track of head node and size of list.
 *
 * @param <T> – the type of elements in this list
 */
public class LinkedList <T>{
    private Node<T> head;
    private int size;

    public Node<T> getHead() {
        return this.head;
    }

    public int getSize() {
        return size;
    }

    public LinkedList() {
        this.size = 0;
    }

    public boolean IsEmpty(){
        return (this.head == null);
    }

    private void addToHead(Node<T> newHead){
        if (this.head != null)
            newHead.setNext(this.head);
        this.head = newHead;
        size++;
    }

    private void addToTail(Node<T> newTail){
        if (this.head == null)
            this.head = newTail;
        else{
            Node<T> currentNode = this.head;
            while (currentNode.hasNext()) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newTail);
        }
        size++;
    }

    public void add(Node<T> node, int index){
//      if index is greater than list size, insertion is impossible, throw error
        if (size < index)
            throw new IndexOutOfBoundsException("index is larger than list");
        if (index == 0){
            addToHead(node);
        }
//      if index is same as list size, add at tail
        else if (size == index){
            addToTail(node);
        }
        else{
            Node<T> currentNode = this.head;
            int counter = 1;
            while (counter != index) {
                currentNode = currentNode.getNext();
                counter++;
            }
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
            size++;
        }
    }

    public void add(Node<T> node){
        addToTail(node);
    }


    public void removeHead() {
        if (this.IsEmpty()) {
            throw new IllegalStateException("can not remove from empty list");
        }
        Node<T> currentHead = this.head;
        if (currentHead.hasNext())
            this.head = currentHead.getNext();
        else
            this.head = null;
        this.size--;
    }

    public void remove(int index) {
        if (this.IsEmpty())
            throw new IllegalStateException("can not remove from empty list");
        if (index < 0)
            throw new IllegalArgumentException("index must be non-negative");
        if (index >= size)
            throw new IndexOutOfBoundsException("index can not be greater than current size " + this.size);

        Node<T> pointer = this.head;
        Node<T> nodeToRemove;
        if (index == 0){
            nodeToRemove = pointer;
        }
        else {
            int counter = 1;
            while (counter != index) {
                pointer = pointer.getNext();
                counter++;
            }
            nodeToRemove = pointer.getNext();
        }

        if (nodeToRemove.hasNext()){
            pointer.setNext(nodeToRemove.getNext());
        }
        else {
            if (nodeToRemove == pointer)
                this.head = null;
            else
                pointer.setNext(null);
        }
        size--;

    }
}
