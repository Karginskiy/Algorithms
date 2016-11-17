package lafore;

public class PriorityQ {

    private int maxSize;
    private long[] queArray;
    private int nElems;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nElems = 0;
    }

    public void insert(long item) {
        int j;
        if (nElems == 0) {
            queArray[nElems++] = item;
        } else {
            for (j = nElems - 1; j >= 0; j--) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = item;
            nElems++;
        }
    }

    public long remove() {
        return queArray[--nElems];
    }

    public long peekMin() {
        return queArray[nElems - 1];
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == maxSize);
    }

}

class PriorityApp {
    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while (!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println(" ");
    }
}
