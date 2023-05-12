package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void Given_LinkedList_When_Empty_Then_AddToHeadShouldAddHeadToList() {
        LinkedList<String> list = new LinkedList<>();
        list.add(new Node<>("liz"), 0);
        assertEquals("liz", list.getHead().getData());
    }

    @Test
    void Given_LinkedList_When_NotEmpty_Then_AddToHeadShouldChangeHeadOfList() {
        LinkedList<String> list = new LinkedList<>();
        list.add(new Node<>("liz"), 0);
        list.add(new Node<>("Mart"), 0);
        assertEquals("Mart", list.getHead().getData());
        assertTrue(list.getHead().hasNext());
    }

    @Test
    void Given_LinkedList_When_NotEmpty_Then_AddToTailShouldChangeTailOfList() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> liz = new Node<>("liz");
        Node<String> major = new Node<>("Major");
        Node<String> mart = new Node<>("Mart");

        list.add(liz, 0);
        list.add(mart, 0);
        list.add(major);

        assertEquals(mart, list.getHead());
        assertEquals(major, liz.getNext());
        assertNull(major.getNext());
    }

    @Test
    void Given_LinkedList_When_Empty_Then_AddToTailShouldChangeTailOfList() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> major = new Node<>("Major");
        list.add(major);

        assertEquals(major, list.getHead());
    }

    @Test
    void Given_LinkedList_When_SizeIs2_Then_AddAtIndex1ShouldAddNodeAtIndex1() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> liz = new Node<>("liz");
        Node<String> major = new Node<>("Major");
        Node<String> mart = new Node<>("Mart");

        list.add(liz, 0);
        list.add(mart, 0);
        list.add(major, 1);

        assertEquals(major, mart.getNext());
        assertEquals(liz, major.getNext());
        assertNull(liz.getNext());
    }

    @Test
    void Given_LinkedList_When_SizeIs2_Then_AddAtIndex5ShouldThrowAnException() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> liz = new Node<>("liz");
        Node<String> major = new Node<>("Major");
        Node<String> mart = new Node<>("Mart");

        list.add(liz, 0);
        list.add(mart, 0);

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(major, 5));
    }

    @Test
    void Given_LinkedList_When_SizeIs2_Then_AddAtIndex2ShouldAddToTail() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> liz = new Node<>("liz");
        Node<String> major = new Node<>("Major");
        Node<String> mart = new Node<>("Mart");

        list.add(liz, 0);
        list.add(mart, 0);
        list.add(major, 2);

        assertEquals(major, liz.getNext());
        assertNull(major.getNext());
    }

    @Test
    void Given_LinkedList_When_SizeIs2_Then_AddAtIndex0ShouldAddToHead() {
        LinkedList<String> list = new LinkedList<>();
        Node<String> liz = new Node<>("liz");
        Node<String> major = new Node<>("Major");
        Node<String> mart = new Node<>("Mart");

        list.add(liz, 0);
        list.add(mart, 0);
        list.add(major, 0);

        assertEquals(major, list.getHead());
        assertEquals(mart, major.getNext());
    }
}