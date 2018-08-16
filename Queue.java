import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private class Node{
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty(){ return first == null; }

    public int size(){ return N; }

    public void enQueue(Item s){
        Node oldLast = last;
        last = new Node();
        last.item = s;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item deQueue(){
        Item res = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return res;
    }



    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{

        private Node a = first;

        @Override
        public boolean hasNext() {
            return a != null;
        }

        @Override
        public Item next() {
            Item s = a.item;
            a = a.next;
            return s;
        }
        
        
        @Override
        public void remove() { }

    }

}
