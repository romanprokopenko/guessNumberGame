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


    public boolean contains(E data){
        Node<E> focusNode = this.root;

        while(data.compareTo(focusNode.data) != 0){
            if(data.compareTo(focusNode.data) < 0){
                focusNode = focusNode.leftChild;
            }
            else{
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null)
                return false;
        }
        return true;

    }

    public boolean remove(E data){
        Node<E> focusNode = this.root;
        Node<E> parentNode = this.root;

        boolean isLeft = true;

        while(data.compareTo(focusNode.data) != 0){

            parentNode = focusNode;

            if(data.compareTo(focusNode.data) < 0){
                focusNode = parentNode.leftChild;
                isLeft = true;
            }
            else{
                focusNode = parentNode.rightChild;
                isLeft = false;
            }
            if(focusNode == null){
                return false;
            }
        }
        //если нет потомков
        if(focusNode.leftChild == null && focusNode.rightChild == null){
            if(focusNode == this.root){
                this.root = null;
                return true;
            }
            if(isLeft){
                parentNode.leftChild = null;
                return true;
            }
            else{
                parentNode.rightChild = null;
                return true;
            }
        }
        //если нет потомков справа
        else if(focusNode.rightChild == null){
            if(focusNode == this.root){
                this.root = null;
                return true;
            }

            if(isLeft){
                parentNode.leftChild = focusNode.leftChild;
                return true;
            }
            else{
                parentNode.rightChild = focusNode.leftChild;
                return true;
            }
        }
        //если нет потомков слева
        else if(focusNode.leftChild == null){
            if(focusNode == this.root){
                this.root = null;
                return true;
            }

            if(isLeft){
                parentNode.leftChild = focusNode.rightChild;
            }
            else{
                parentNode.rightChild = focusNode.rightChild;
            }
        }
        //потомки есть
        else{

            Node<E> replacement = getReplacementNode(focusNode);

            if(focusNode == this.root){
                this.root = replacement;
            }
            else if(isLeft){
                parentNode.leftChild = replacement;
            }
            else{
                parentNode.rightChild = replacement;
            }

            replacement.leftChild = focusNode.leftChild;

        }
        return true;
    }

    private Node<E> getReplacementNode(Node<E> replacedNode) {
        Node<E> replacementNode = replacedNode;
        Node<E> replacementParentNode = replacedNode;
        Node<E> focusNode = replacedNode.rightChild;
        //пока не дойдем до самой глубокой левой ноды
        while(focusNode != null){
            replacementParentNode = replacementNode;
            replacementNode = focusNode;
            focusNode = focusNode.leftChild;
        }
        if(replacementNode != replacedNode.rightChild){
            replacementParentNode.leftChild = replacementNode.rightChild;
            replacementNode.rightChild = replacedNode.rightChild;
        }
        return replacementNode;
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
