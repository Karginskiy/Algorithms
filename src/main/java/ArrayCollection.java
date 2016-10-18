import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayCollection<T> implements Collection<T> {

    @SuppressWarnings("unchecked")
    private T[] m = (T[])new Object[10];

    private int size = 0;

    @Override
    public int size() {
        // BEGIN (write your solution here)
        return this.size;
        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)
        return this.size() == 0;
        // END
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)
        for (Object value : m) {
            if (value == o) {
                return true;
            }
        }
        return false;
        // END
    }

    @Override
    public Iterator<T> iterator() {
        // BEGIN (write your solution here)
        return new ElementsIterator();
        // END
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        // BEGIN (write your solution here)
        final T[] newM = (T[]) new Object[this.size()];
        System.arraycopy(m, 0, newM, 0, this.size());
        return newM;
        // END
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        return (T1[]) this.toArray();
        // END
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(final T t) {
        // BEGIN (write your solution here)
        if (m.length == size) {
            final T[] oldM = m;
            m = (T[]) new Object[this.size() * 2];
            System.arraycopy(oldM, 0, m, 0, oldM.length);
            m[size++] = t;
            return true;
        } else {
            m[size++] = t;
        }
        return false;
        // END
    }

    @Override
    public boolean remove(final Object o) {
        // BEGIN (write your solution here)
        for (int i = 0; i < this.size(); i++) {
            if (m[i].equals(o)) {
                if (i != this.size() - 1) {
                    System.arraycopy(m, i + 1, m, i, this.size() - i);
                }
                this.size--;
                return true;
            }
        }
        return false;
        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        // BEGIN (write your solution here)
        for (Object value : c) {
            if (!this.contains(value)) {
                return false;
            }
        }
        return true;
        // END
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        // BEGIN (write your solution here)
        for (T obj : c) {
            this.add(obj);
        }
        return true;
        // END
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean removeAll(final Collection<?> c) {
        // BEGIN (write your solution here)
        for (Object obj : c) {
            this.remove((T) obj);
            return true;
        }
        return false;
        // END
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        // BEGIN (write your solution here)
        for (T obj : this) {
            if (!c.contains(obj)) this.remove(obj);
            size--;
        }
        return true;
        // END
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        // BEGIN (write your solution here)
        this.size = 0;
        this.m = (T[]) new Object[size];
        // END
    }

    private class ElementsIterator implements Iterator<T> {
        // BEGIN (write your solution here)
        private int size = 0;

        public boolean hasNext() {
            return ArrayCollection.this.size() > size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return ArrayCollection.this.m[size++];
        }

        @Override
        public void remove() {
            if (size < ArrayCollection.this.size() - 1) {
                System.arraycopy(ArrayCollection.this.m, size + 1,
                        ArrayCollection.this.m, size, ArrayCollection.this.size() - size - 1);
            }
        }
        // END
    }

}
