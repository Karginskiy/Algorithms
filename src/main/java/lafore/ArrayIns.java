package lafore;

public class ArrayIns {

    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void insertionSort() {
        int in, out;

        for (out=1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }
}

class InsertSortApp {

    public static void main(String[] args) {

        int maxSize = 100;
        ArrayIns arr = new ArrayIns(100);
        arr.insert(50);
        arr.insert(30);
        arr.insert(20);
        arr.insert(1000);
        arr.insert(10);
        arr.insert(12);

        arr.display();
        arr.insertionSort();
        arr.display();

    }

}
