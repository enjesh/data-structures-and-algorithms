package test;

import main.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    Node firstNode = new Node("Node 1");
    Node secondNode = new Node("Node 2");
    @Test
    public void whenNode2LinkedToNode1_getNext_ShouldReturnANode(){
        firstNode.setNext(secondNode);
        assertEquals(firstNode.getNext(), secondNode);
    }
}
