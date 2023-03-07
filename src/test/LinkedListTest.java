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
        list.addToHead(new Node<>("data"));
        assertNotNull(list.getHead());
    }

    @Test
    public void Given_ALinkedListWithAHead_When_GivenNewHead_ThenHeadShouldPointToNewNode(){
        LinkedList list = new LinkedList();
        Node<String> currentHead = new Node<>("data");
        Node<String> newHead = new Node<>("another data");
        list.addToHead(currentHead);
        list.addToHead(newHead);
        assertEquals(list.getHead(),newHead);
    }

    @Test
    public void Given_ALinkedListWithAHead_When_GivenNewHead_ThenNewHeadNextNodeShouldNotBeNull(){
        LinkedList list = new LinkedList();
        Node<String> currentHead = new Node<>("data");
        Node<String> newHead = new Node<>("another data");
        list.addToHead(currentHead);
        list.addToHead(newHead);
        assertDoesNotThrow(() -> {newHead.getNext();});
    }

    @Test
    public void Given_ALinkedListWithAHead_When_GivenNewHead_ThenNewHeadShouldLinkToOldNode(){
        LinkedList list = new LinkedList();
        Node<String> currentHead = new Node<>("data");
        Node<String> newHead = new Node<>("another data");
        list.addToHead(currentHead);
        list.addToHead(newHead);
        assertEquals(newHead.getNext(),currentHead);
    }

    @Test
    public void Given_ALinkedListWithAHead_When_GivenNewHead_ThenOldHeadShouldBeTail(){
        LinkedList list = new LinkedList();
        Node<String> currentHead = new Node<>("data");
        Node<String> newHead = new Node<>("another data");
        list.addToHead(currentHead);
        list.addToHead(newHead);
        assertEquals(list.getTail(),currentHead);
    }

    @Test
    public void Given_ALinkedListWithANode_Then_HeadAndTailShouldPointToTheSameNode(){
        LinkedList list = new LinkedList();
        Node<String> currentHead = new Node<>("data");
        list.addToHead(currentHead);
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void Given_EmptyLinkedList_When_AddingToTail_Then_ThrowNullPointerException(){
        LinkedList list = new LinkedList();
        assertThrows(NullPointerException.class, () -> list.addToTail(new Node<>("data")));
    }

    @Test
    public void Given_LinkedListWithANode_When_AddToTail_Then_HeadNextShouldBeTail(){
        LinkedList list = new LinkedList();
        Node<String> newTail = new Node<>("new Tail");
        list.addToHead(new Node<>("data"));
        list.addToTail(newTail);
        assertEquals(list.getHead().getNext(), list.getTail());
    }

    @Test
    public void Given_LinkedListWithATail_When_AddToTail_Then_CurrentTailShouldPointToNewTail(){
        LinkedList list = new LinkedList();
        list.addToHead(new Node<>("data"));
        list.addToTail(new Node<>("current Tail"));
        Node<String> currentTail = list.getTail();
        Node<String> newTail = new Node<>("new Tail");
        list.addToTail(newTail);
        assertEquals(currentTail.getNext(), newTail);

    }

    @Test
    public void Given_EmptyLinkedList_When_AddingANode_Then_ShouldAddToHead(){
        LinkedList list = new LinkedList();
        Node<String> newNode = new Node<>("data");
        list.add(newNode);
        assertEquals(list.getHead(), newNode);
        assertEquals(list.getHead(),list.getTail());
    }

    @Test
    public void Given_LinkedListWithANode_When_AddingANode_Then_ShouldAddToTail(){
        LinkedList list = new LinkedList();
        list.addToHead(new Node<>("data"));
        Node<String> newNode = new Node<>("new node");
        list.add(newNode);
        assertEquals(list.getTail(), newNode);
    }

//    @Test
//    public void Given_LinkedListWithANode_When_AddingANode_Then_



    @Test
    public void Given_LinkedListWithANode_Then_PrintShouldReturnANode(){
        LinkedList list = new LinkedList();
        list.addToHead(new Node<>("data"));
        assertEquals(list.print(), "<head> data <tail>");
    }
}
