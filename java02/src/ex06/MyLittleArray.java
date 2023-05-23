package ex06;

import java.util.Arrays;

public class MyLittleArray<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyLittleArray() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elements[i]).append(", ");
        }
        sb.append(elements[size - 1]).append("]");

        return sb.toString();
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = element;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    public boolean contains(T object) {
        return indexOf(object) != -1;
    }

    public int indexOf(T object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    public int size() {
        return size;
    }
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public static void main(String[] args) {

                // ArrayList 객체 생성
                MyLittleArray<Integer> list = new MyLittleArray<>();

                // add() 메서드 테스트
                list.add(1);
                list.add(2);
                list.add(3);
                System.out.println("list : " + list);

                // add(index, element) 메서드 테스트
                list.add(1, 4);
                System.out.println("list : " + list);

                // get() 메서드 테스트
                int element = list.get(2);
                System.out.println("element : " + element);

                // set() 메서드 테스트
                list.set(3, 5);
                System.out.println("list : " + list);

                // remove() 메서드 테스트
                list.remove(1);
                System.out.println("list : " + list);

                // contains() 메서드 테스트
                boolean containsElement = list.contains(3);
                System.out.println("containsElement : " + containsElement);

                // indexOf() 메서드 테스트
                int index = list.indexOf(5);
                System.out.println("index : " + index);

                // size() 메서드 테스트
                int size = list.size();
                System.out.println("size : " + size);
        }
    }
