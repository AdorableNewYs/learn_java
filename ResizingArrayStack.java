import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{

    private Item[] a = (Item[])new Object[1];
    private int N;

    public int size(){ return N; }

    public boolean isEmpty(){return N == 0;}

    private void resize(int max){
        Item[] t = (Item[])new Object[max];
        for(int i = 0;i < N;i++){
            t[i] = a[i];
        }
        a = t;
    }

    public Item pop(){
        Item res = a[--N];
        a[N+1] = null;
        if(N > 0 && N <= a.length / 4) resize(a.length / 2);
        return res;
    }

    public void push(Item item){
        if(N == a.length) resize(a.length * 2);
        a[N++] = item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{

        int s = N;

        @Override
        public boolean hasNext() { return s > 0; }

        @Override
        public Item next() { return a[--s]; }

        @Override
        public void remove() { }

    }
}
