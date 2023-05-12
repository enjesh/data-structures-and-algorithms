package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void Given_ANode_then_hasNextShouldReturnFalse_When_NodeHasNoNext() {
        Node<String> node1 = new Node<>("lizy");
        assertFalse(node1.hasNext());
    }

    @Test
    void Given_ANode_then_hasNextShouldReturnTrue_When_NodeHasNext() {
        Node<String> node1 = new Node<>("lizy");
        Node<String> node2 = new Node<>("Mart");
        node1.setNext(node2);
        assertTrue(node1.hasNext());
    }
}