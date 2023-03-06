package test;

import main.LinkedList;
import main.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void Given_AnEmptyLinkedList_then_ItShouldNotHaveAHeadAndTail(){
        LinkedList list = new LinkedList();
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void Given_AnEmptyLinkedList_When_HeadIsAdded_Then_HeadShouldNotBeNull(){
        LinkedList list = new LinkedList();
        list.addToHead(new Node<String>("data"));
        assertNotNull(list.getHead());
    }

    @Test
    public void Given_ALinkedListWithAHead_When_GivenNewHead_ThenHeadShouldPointToNewNode(){
        LinkedList list = new LinkedList();
        Node currentHead = new Node<String>("data");
        Node newHead = new Node<String>("another data");
        list.addToHead(currentHead);
        list.addToHead(newHead);
        assertEquals(list.getHead(),newHead);
    }

    @Test
    public void Given_ALinkedListWithAHead_When_GivenNewHead_ThenNewHeadNextNodeShouldNotBeNull(){
        LinkedList list = new LinkedList();
        Node currentHead = new Node<String>("data");
        Node newHead = new Node<String>("another data");
        list.addToHead(currentHead);
        list.addToHead(newHead);
        assertDoesNotThrow(() -> {newHead.getNext();});
    }

    @Test
    public void Given_ALinkedListWithAHead_When_GivenNewHead_ThenNewHeadShouldLinkToOldNode(){
        LinkedList list = new LinkedList();
        Node currentHead = new Node<String>("data");
        Node newHead = new Node<String>("another data");
        list.addToHead(currentHead);
        list.addToHead(newHead);
        assertEquals(newHead.getNext(),currentHead);
    }

    @Test
    public void Given_ALinkedListWithANode_Then_HeadAndTailShouldPointToTheSameNode(){
        LinkedList list = new LinkedList();
        Node currentHead = new Node<String>("data");
        list.addToHead(currentHead);
        assertTrue(list.getHead().equals(list.getTail()));
    }

    @Test
    public void Given_EmptyLinkedList_When_AddingToTail_Then_ThrowNullPointerException(){
        LinkedList list = new LinkedList();
        assertThrows(NullPointerException.class, () -> list.addToTail(new Node<String>("data")));
    }

    @Test
    public void Given_LinkedListWithANode_When_AddToTail_Then_HeadNextShouldBeTail(){
        LinkedList list = new LinkedList();
        Node newTail = new Node<>("new Tail");
        list.addToHead(new Node<String>("data"));
        list.addToTail(newTail);
        assertTrue(list.getHead().getNext().equals(list.getTail()));
    }

    @Test
    public void Given_LinkedListWithATail_When_AddToTail_Then_CurrentTailShouldPointToNewTail(){
        LinkedList list = new LinkedList();
        list.addToHead(new Node<String>("data"));
        list.addToTail(new Node<>("current Tail"));
        Node currentTail = list.getTail();
        Node newTail = new Node<>("new Tail");
        list.addToTail(newTail);
        assertTrue(currentTail.getNext().equals(newTail));

    }

}
