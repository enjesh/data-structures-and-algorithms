package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void Given_LinkedList_When_Empty_Then_AddToHeadShouldAddHeadToList() {
        LinkedList<String> list = new LinkedList<>();
        list.addToHead(new Node<>("liz"));
        assertEquals("liz", list.getHead().getData());
    }

    @Test
    void Given_LinkedList_When_NotEmpty_Then_AddToHeadShouldChangeHeadOfList() {
        LinkedList<String> list = new LinkedList<>();
        list.addToHead(new Node<>("liz"));
        list.addToHead(new Node<>("Mart"));
        assertEquals("Mart", list.getHead().getData());
        assertTrue(list.getHead().hasNext());
    }

    @Test
    void Given_LinkedList_When_NotEmpty_Then_AddToTailShouldChangeTailOfList() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> liz = new Node<>("liz");
        Node<String> major = new Node<>("Major");
        Node<String> mart = new Node<>("Mart");

        list.addToHead(liz);
        list.addToHead(mart);
        list.addToTail(major);

        assertEquals(mart, list.getHead());
        assertEquals(major, liz.getNext());
        assertNull(major.getNext());
    }

    @Test
    void Given_LinkedList_When_Empty_Then_AddToTailShouldChangeTailOfList() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> major = new Node<>("Major");
        list.addToTail(major);

        assertEquals(major, list.getHead());
    }
}