package test;

import main.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    Node firstNode = new Node("Node 1");
    Node secondNode = new Node("Node 2");
    @Test
    public void Given_TwoNodes_When_OneLinksToTheOther_Then_getNextShouldReturnANode(){
        firstNode.setNext(secondNode);
        assertEquals(firstNode.getNext(), secondNode);
    }
    @Test
    public void Given_aNode_When_itHasNoPointer_Then_getNextShouldThrowNullPointerException(){
        assertThrows(NullPointerException.class, () -> {firstNode.getNext();});
    }

    @Test
    public void Given_aNode_whenNodeLinksToItself_Then_throwIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->firstNode.setNext(firstNode));
    }

    @Test
    public void Given_aNode_whenNodeHasNoNextNode_Then_hasNextShouldReturnFalse(){
        assertFalse(new Node<String>("this").hasNext());
    }

}
