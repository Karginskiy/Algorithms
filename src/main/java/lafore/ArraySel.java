package lafore;

public class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void selectionSort() {
        int in, out, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

class SelectSortApp {

    public static void main(String[] args) {

        int maxSize = 100;
        ArraySel arraySel = new ArraySel(100);
        arraySel.insert(50);
        arraySel.insert(30);
        arraySel.insert(20);
        arraySel.insert(1000);
        arraySel.insert(10);
        arraySel.insert(12);

        arraySel.display();

        arraySel.selectionSort();

        arraySel.display();

    }

}
