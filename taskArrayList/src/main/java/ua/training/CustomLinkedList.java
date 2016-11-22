package ua.training;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by Graffit on 21.11.2016.
 */
public class CustomLinkedList<E> implements List<E> {

    private static final String OUT_OF_BOUNDS = "index out of bounds";

    /**
     * Inner class wich represent nodes of list
     *
     * @param <E> type of data it holds
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Reference to firs node
     */
    private Node<E> first;

    /**
     * Reference to last node
     */
    private Node<E> last;

    /**
     * Size of list
     */
    private int size = 0;

    /**
     * Constructs empty list
     */
    public CustomLinkedList() {}

    /**
     * Checks if index is in bounds. If not so throws
     * IndexOutOfBoundsException
     *
     * @param index
     */
    private void checkIndexInBounds(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(OUT_OF_BOUNDS);
        }
    }

    /**
     * Sets e as head of list
     *
     * @param e data to store
     */
    private void linkFirst(E e) {
        Node<E> oldFirstNode = first;
        Node<E> newNode = new Node<E>(null, e, oldFirstNode);
        first = newNode;
        if (oldFirstNode == null) {
            last = newNode;
        } else {
            oldFirstNode.prev = newNode;
        }
        size++;
    }

    /**
     * Sets e as tail of list
     *
     * @param e data to store
     */
    private void linkLast(E e) {
        Node<E> oldLastNode = last;
        Node<E> newNode = new Node<E>(oldLastNode, e, null);
        last = newNode;
        if (oldLastNode == null) {
            first = newNode;
        } else  {
            oldLastNode.next = newNode;
        }
        size++;
    }

    /**
     * Add new elem before nextNode
     *
     * @param e
     */
    private void linkBefore(E e, Node<E> nextNode) {
        Node<E> beforeNextNode = nextNode.prev;
        Node<E> newNode = new Node<E>(beforeNextNode, e, nextNode);
        nextNode.prev = newNode;
        if (newNode.prev == null) {
            first = newNode;
        } else {
            beforeNextNode.next = newNode;
        }
        size++;
    }

    /**
     * Removes head of list, and sets next element as head
     *
     * @return removed element data
     */
    private E unlinkFirst() {
        E data = first.item;
        Node<E> nextToFirstNode = first.next;
        first = nextToFirstNode;
        if (nextToFirstNode == null) {
            last = null;
        } else {
            nextToFirstNode.prev = null;
        }
        size--;
        return data;
    }

    /**
     * Removes tail of list, and sets previous element as tail
     *
     * @return removed element data
     */
    private E unlinkLast() {
        E data = last.item;
        Node<E> prevToLastNode = last.prev;
        last = prevToLastNode;
        if (prevToLastNode == null) {
            first = null;
        } else {
            prevToLastNode.next = null;
        }
        size--;
        return data;
    }

    /**
     * Removes selected node
     *
     * @param nodeToUnlink node to remove
     * @return removed node data
     */
    private E unlinkNode(Node<E> nodeToUnlink) {
        E data = nodeToUnlink.item;
        Node<E> previousNode = nodeToUnlink.prev;
        Node<E> nextNode = nodeToUnlink.next;

        if (previousNode == null) {
            first = nextNode;
        } else {
            previousNode.next = nextNode;
            nodeToUnlink.prev = null;
        }

        if (nextNode == null) {
            last = previousNode;
        } else {
            nextNode.prev = previousNode;
            nodeToUnlink.next = null;
        }

        nodeToUnlink.item = null;
        size--;
        return data;
    }

    /**
     * Returns node with selected index
     *
     * @param index index of element in list
     * @return node
     */
    private Node<E> getNodeByIndex(int index) {
        Node<E> currentNode = first;
        for (int i = 0; i != index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * Returns size of list
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if list contains at least 1 node
     *
     * @return true if contains
     */
    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    /**
     * Adds new node at the end of list
     *
     * @param e data to store
     * @return true if added
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * Clears the list
     */
    @Override
    public void clear() {
        for (Node<E> currentNode = first; currentNode != null; ) {
            Node<E> nextNode = currentNode.next;
            currentNode.item = null;
            currentNode.next = null;
            currentNode.prev = null;
            currentNode = nextNode;
        }
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns node data with selected index
     *
     * @param index index
     * @return node data
     */
    @Override
    public E get(int index) {
        checkIndexInBounds(index);
        return getNodeByIndex(index).item;
    }

    /**
     * Sets new data at node with selected index
     *
     * @param index index of node
     * @param element data to store
     * @return old data
     */
    @Override
    public E set(int index, E element) {
        checkIndexInBounds(index);
        Node<E> nodeToSetNewData = getNodeByIndex(index);
        E oldData = nodeToSetNewData.item;
        nodeToSetNewData.item = element;
        return oldData;
    }

    /**
     * Adds new node at selected index
     *
     * @param index index
     * @param element data to store
     */
    @Override
    public void add(int index, E element) {
        if ((0 <= index) && (index <= size)) {
            if (index == size) {
                linkLast(element);
            } else {
                linkBefore(element, getNodeByIndex(index));
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes node at selected index
     *
     * @param index index
     * @return removed node data
     */
    @Override
    public E remove(int index) {
        checkIndexInBounds(index);
        return unlinkNode(getNodeByIndex(index));
    }

    public E peek() {
        return (first == null) ? null : first.item;
    }

    public E peekLast() {
        return (last == null) ? null : last.item;
    }

    public E poll() {
        return (first == null) ? null : unlinkFirst();
    }

    public E pollLast() {
        return (last == null) ? null : unlinkLast();
    }

    public void push(E e) {
        linkFirst(e);
    }

    public E pop() {
        return poll();
    }

    /**
     * Returns array representation of list
     *
     * @return
     */
    @Override
    public E[] toArray() {
        Object[] dataArray = new Object[size];
        int i = 0;
        for (Node<E> currentNode = first; currentNode != null; i++) {
            dataArray[i] = currentNode.item;
            currentNode = currentNode.next;
        }
        return (E[]) dataArray;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            return new CustomListIterator(index);
        }
    }

    private class CustomListIterator implements ListIterator<E> {

        private Node<E> lastReturned;
        private Node<E> nextNode;
        private int nextIndex;

        public CustomListIterator(int index) {
            nextNode = getNodeByIndex(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                lastReturned = nextNode;
                nextNode = lastReturned.next;
                nextIndex++;
                return lastReturned.item;
            }
        }

        @Override
        public boolean hasPrevious() {
            return 0 < nextIndex;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            } else {
                nextNode = (nextNode == null) ? last : nextNode.prev;
                lastReturned = nextNode;
                nextIndex--;
                return lastReturned.item;
            }
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            } else {
                Node<E> nextToLastReturned = lastReturned.next;
                unlinkNode(lastReturned);
                if(lastReturned == nextNode) {
                    nextNode = nextToLastReturned;
                } else {
                    nextIndex--;
                }
                lastReturned = null;
            }
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            } else {
                lastReturned.item = e;
            }
        }

        @Override
        public void add(E e) {
            lastReturned = null;
            if (nextNode == null) {
                linkLast(e);
            } else {
                linkBefore(e, nextNode);
            }
            nextIndex++;
        }
    }

    //NOT IMPLEMENTED

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }
}
