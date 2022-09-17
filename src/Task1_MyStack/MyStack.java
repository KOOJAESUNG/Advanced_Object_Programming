package Task1_MyStack;

import java.util.ArrayList;
import java.util.Iterator;

//제네릭스 ArrayList를 이용해서 제네릭스 스택(MyStack) 자료구조 구현
//
//MyStack은 iterator를 지원해서 스택의 요소들을 위에서 아래 방향으로 pop하지 않고 한 개씩 확인 가능
//
//for-each에서도 사용할 수 있게 구현할 것(Iterable<E> 구현)
//
//제공하는 Main.java와 동작하도록 만들 것
public class MyStack<E> implements Iterable<E> {
    ArrayList<E> stack;
    private int size;

    public MyStack() {
        stack = new ArrayList<E>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        stack.add(e);
        size++;
    }

    public E pop() {
        if (!isEmpty()) {
            size--;
            return stack.get(size);
        } else {
            System.out.println("스택이 비어있습니다.");
            return null;
        }
    }
    public class StackIterator implements Iterator<E> {
        int index;

        public StackIterator() {
            index = size-1;
        }

        public boolean hasNext() { return index >= 0; }

        public E next() {
            E o = stack.get(index);
            index--;
            return o;
        }
    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }
}
