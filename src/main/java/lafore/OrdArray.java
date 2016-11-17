package lafore;

public class OrdArray {

    public static void main(String[] args) {

        OrdArray array = new OrdArray(10);
        array.insert(25);
        array.insert(35);
        array.insert(55);
        array.insert(15);
        array.insert(5);

        int searchKey = 55;
        if (array.find(searchKey) != array.size()) {
            System.out.println("Found: " + searchKey);
        }

    }

    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        this.a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {

            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }

        }
    }

    public void insert(long value) {

        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i] > value) {
                break;
            }
        }
        for (int j = nElems; j > i; j--) {
            a[j] = a[j - 1];
        }
        a[i] = value;
        nElems++;

    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int i = j; i < nElems; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
