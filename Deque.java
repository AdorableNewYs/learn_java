import Std.StdOut;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{

    private class DoubleNode{
        Item item;
        DoubleNode next,previous;
    }

    private DoubleNode left,right;
    private int N;

    public boolean isEmpty(){ return N == 0; }

    public int size(){ return N; }

    public void pushLeft(Item item){
        DoubleNode oldLeft = left;
        left = new DoubleNode();
        left.item = item;
        if(isEmpty()) right = left;
        else {
            oldLeft.previous = left;
            left.next = oldLeft;
        }
        N++;
    }

    public void pushRight(Item item){
        DoubleNode oldRight = right;
        right = new DoubleNode();
        right.item = item;
        if(isEmpty()) left = right;
        else {
            oldRight.next = right;
            right.previous = oldRight;
        }
        N++;
    }

    public Item popLeft(){
        Item res = left.item;
        N--;
        left = left.next;
        if(isEmpty()) right = null;
        else left.previous = null;
        return res;
    }

    public Item popRight(){
        Item res = right.item;
        N--;
        right = right.previous;
        if(isEmpty()) left = null;
        else right.next = null;
        return res;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{

        DoubleNode N = left;

        @Override
        public boolean hasNext() {
            return N != null;
        }

        @Override
        public Item next() {
            Item item = N.item;
            N = N.next;
            return item;
        }

        @Override
        public void remove() { }
    }

    public static void main(String[] args){

        Deque<Integer> d = new Deque<>();

        for(int i = 0; i < 40 ; i++){
            d.pushRight(i + 4);
        }
        for(int i = 0; i < 40 ; i++){
            d.pushLeft(40 - i);
        }

        for(Integer i : d){
            StdOut.print(i+ " ");
        }
        StdOut.println();
        StdOut.println(d.popLeft());
        StdOut.println(d.popRight());
        StdOut.println(d.size());
        for(Integer i : d){
            StdOut.print(i+ " ");
        }


    }

}
