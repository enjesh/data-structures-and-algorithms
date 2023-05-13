package org.example;

/**
 * Implementation of Linkedlist that uses Node class
 * Keeping track of head node and size of list.
 *
 * @param <T> – the type of elements in this list
 */
public class LinkedList <T>{
    private Node<T> head;
    private int size = 0;

    public Node<T> getHead() {
        return this.head;
    }

    /**
     * Adds a new node to the beginning of the linked list.
     *
     * @param newHead the new node to add as the new head of the list.
     */
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
            size++;
        }
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

}
