package lafore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StackX {

    private int maxSize;
    private char[] stackArray;
    private int top;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char val) {
        lock.writeLock().lock();
        stackArray[++top] = val;
        lock.writeLock().unlock();
    }

    public char pop() {
        lock.writeLock().lock();
        char topElement = stackArray[top--];
        lock.writeLock().unlock();
        return topElement;
    }

    public char peek() {
        lock.readLock().lock();
        char topElem = stackArray[top];
        lock.readLock().unlock();
        return topElem;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

class StackApp {
    public static void main(String[] args) {

        StackX stackX = new StackX(10);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> {
            stackX.push('a');
            stackX.push('b');
            stackX.push('b');
            stackX.push('c');
        });

        service.submit(() -> {
            System.out.println(stackX.pop());
            System.out.println(stackX.pop());
            System.out.println(stackX.pop());
        });

        service.submit(() -> {
            System.out.println(stackX.peek());
            System.out.println(stackX.peek());
            System.out.println(stackX.peek());
        });

        service.shutdown();

    }
}
