package lafore.recursion;

public class OrderedArray {
    private long[] a;
    private int nElems;

    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == searchKey) {
            return curIn;
        } else if (lowerBound > upperBound) {
            return nElems;
        } else {
            if (a[curIn] < searchKey){
                return recFind(searchKey, curIn + 1, upperBound);
            } else {
                return recFind(searchKey, lowerBound, curIn - 1);
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value) {
                break;
            }
        }

        for (int k = nElems; k > j; k++) {
            a[k] = a[k - 1];
        }
        a[j] = value;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i]);
        }
        System.out.println("");
    }

}

class BinarySearchApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderedArray array = new OrderedArray(maxSize);

        array.insert(50L);
        array.insert(30L);
        array.insert(20L);
        array.insert(10L);
        array.insert(160L);

        array.display();

        int searchKey = 20;
        if (array.find(searchKey) != array.size()) {
            System.out.println("Found: " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

    }
}
