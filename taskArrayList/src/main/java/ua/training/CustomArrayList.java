package ua.training;


import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by Roman Prokopenko on 20.11.2016.
 */
public class CustomArrayList<E> implements List<E>{

    private static final String ERROR_NEGATIVE_SIZE = "size set lesser than 0";
    private static final String OUT_OF_BOUNDS = "index out of bounds";
    private static final int DEFAULT_SIZE = 16;

    /**
     * size of list
     */
    private int size = 0;

    /**
     * array of data
     */
    private Object[] dataArray;

    /**
     * Constructor with parameters
     *
     * @param initialSize size of list. Must be greater than 0
     */
    public CustomArrayList(int initialSize) {
        ensureNotNegative(initialSize, ERROR_NEGATIVE_SIZE);
        dataArray = new Object[initialSize];
    }

    /**
     * Creates new list with default size
     */
    public CustomArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * If number is negative throws IllegalArgumentException
     * with message
     *
     * @param number integer to check
     * @param message error message
     */
    private void ensureNotNegative(int number, String message) {
        if(number < 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks if param size bigger than length of inner array.
     * If so creates new array with 1.5 bigger length and copy data
     * from old array into new
     *
     * @param size
     */
    private void ensureSize(int size) {
        ensureNotNegative(size, ERROR_NEGATIVE_SIZE);
        if (size > dataArray.length) {
            int newDataArrayLength = (int) (dataArray.length * 1.5);
            if (newDataArrayLength < size) {
                newDataArrayLength = size;
            }
            Object[] newDataArray = new Object[newDataArrayLength];
            System.arraycopy(dataArray, 0, newDataArray, 0, size);
            dataArray = newDataArray;
        }
    }

    /**
     * Checks if index bigger than 0 and lesser than size
     *
     * @param index index to check
     */
    private void checkIndexInBounds(int index) {
        ensureNotNegative(index, OUT_OF_BOUNDS);
        if (index >= size) {
            throw new IndexOutOfBoundsException(OUT_OF_BOUNDS);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add new element at the end of list.
     * Increase size by 1.
     *
     * @param e element to add
     * @return result
     */
    @Override
    public boolean add(E e) {
        ensureSize(size + 1);
        dataArray[size] = e;
        size++;
        return true;
    }

    /**
     * Sets all inner array values to null.
     * Sets size to 0.
     */
    @Override
    public void clear() {
        for (int i = 0; i < dataArray.length; i++) {
            dataArray[i] = null;
        }
        size = 0;
    }

    /**
     * Gets data from list
     *
     * @param index index of element
     * @return element
     */
    @Override
    public E get(int index) {
        checkIndexInBounds(index);
        return (E) dataArray[index];
    }

    /**
     * Sets element into index
     *
     * @param index index to set
     * @param element element
     * @return element
     */
    @Override
    public E set(int index, E element) {
        checkIndexInBounds(index);
        dataArray[index] = element;
        return (E) dataArray[index];
    }

    /**
     * Adds new element at index
     *
     * @param index index to add
     * @param element element
     */
    @Override
    public void add(int index, E element) {
        checkIndexInBounds(index);
        ensureSize(size + 1);
        System.arraycopy(dataArray, index, dataArray, index + 1, size - index);
        dataArray[index] = element;
        size++;
    }

    /**
     * Remove element at index
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        checkIndexInBounds(index);
        E element = get(index);
        if (index < size - 1) {
            System.arraycopy(dataArray, index + 1, dataArray, index, size - index - 1);
        }
        dataArray[size - 1] = null;
        size--;
        return element;
    }

    /**
     * Returns new CustomListIterator at 0 index
     *
     * @return CustomListIterator
     */
    @Override
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    /**
     * Returns new CustomListIterator at selected index
     *
     * @param index index
     * @return CustomListIterator
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return new CustomListIterator(index);
    }

    private class CustomListIterator implements ListIterator<E> {

        /**
         * Pointer at current index
         */
        int currentIndex;

        /**
         * Last returned element
         */
        int lastReturned = -1;

        /**
         * Sets currentIndex as index
         *
         * @param index start index
         */
        public CustomListIterator(int index) {
            this.currentIndex = index;
        }

        @Override
        public boolean hasNext() {
            return currentIndex != size;
        }

        @Override
        public E next() {
            if (currentIndex >= size) {
                throw new NoSuchElementException();
            } else {
                lastReturned = currentIndex;
                currentIndex++;
                return (E) CustomArrayList.this.dataArray[lastReturned];
            }
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public E previous() {
            currentIndex--;
            if (currentIndex < 0) {
                throw new NoSuchElementException();
            } else {
                lastReturned = currentIndex;
                return (E) CustomArrayList.this.dataArray[lastReturned];
            }
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            } else {
                CustomArrayList.this.remove(lastReturned);
                currentIndex = lastReturned;
                lastReturned = -1;
            }
        }

        @Override
        public void set(E e) {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            }
            CustomArrayList.this.set(lastReturned, e);
        }

        @Override
        public void add(E e) {
            CustomArrayList.this.add(currentIndex, e);
            currentIndex++;
            lastReturned = -1;
        }
    }


    @Override
    public E[] toArray() {
        Object[] resultArray = new Object[size];
        System.arraycopy(dataArray, 0, resultArray, 0, size);
        return (E[]) resultArray;
    }

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
