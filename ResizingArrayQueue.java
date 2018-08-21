
import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Iterable<Item>{
    private int first;
    private int last;
    private Item[] Q =(Item[]) new Object[1];

    //first指向队第一个元素的下标，last指向队最后一个元素后一个下标

    public int size(){ return last >= first ?
                                last - first:
                                last - first + Q.length; }
    public boolean isEmpty(){ return last == first; }

    private void resize(int max){
        Item[] res = (Item[]) new Object[max];
        for(int i = 0; i < size() ; i++){
            res[i] = Q[(i + first) % Q.length];
        }
        Q = res;
    }

    public void enQueue(Item s){
        if(size() == Q.length - 1) resize(2 * Q.length);
        Q[last] = s;
        last = (last + 1) % Q.length;
    }

    public Item deQueue(){
        Item res = Q[first];
        Q[first] = null;
        first = (first + 1) % Q.length;
        if(size() > 0 && size() <= Q.length / 4) resize(Q.length / 2);
        return res;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{

        int i = 0;

        @Override
        public boolean hasNext() {
            return i < size();
        }

        @Override
        public Item next() {
            return Q[(i++ + first) % Q.length];
        }
    }

}
