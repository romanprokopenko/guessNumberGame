package ua.training;

/**
 * Created by Graffit on 25.11.2016.
 */
public class CustomTreeSet<E extends Comparable<E>> {

    private static class Node<E> {
        E data;
        Node<E> leftChild;
        Node<E> rightChild;

        public Node(E data, Node<E> leftChild, Node<E> rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }


    }

    private Node<E> root;
    private int size = 0;

    public CustomTreeSet() {
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data, null, null);
        if (root == null) {
            root = newNode;
        } else {
            Node<E> focusNode = root;
            Node<E> parentNode;
            while (true) {
                parentNode = focusNode;
                //if data lesser than current put it left
                if (data.compareTo(focusNode.data) < 0) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }

//                      if data greater than current put it right
                } else if (data.compareTo(focusNode.data) > 0) {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
//                    if data equals to current node than we don't have to add it
                } else if (data.compareTo(focusNode.data) == 0) {
                    return;
                }
            }
        }
    }

    public void testShow() {
        display(root);
    }

    private void display(Node<E> node) {
        if (node != null) {
            display(node.leftChild);
            System.out.println(node.data.toString());
            display(node.rightChild);
        }
    }
}
