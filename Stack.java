import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

    private class Node{
        Item item;
        Node next;
    }

    private Node top;
    private int N;

    public boolean isEmpty(){return top == null;}

    public Item pop(){
        if(isEmpty()){
            return null;
        }
        Node ret = top;
        top = top.next;
        N--;
        return ret.item;
    }

    public void push(Item s){
        N++;
        Node oldTop = top;
        top = new Node();
        top.item = s;
        top.next = oldTop;
    }

     //1.3.7
    public Item peek(){ return top.item; }

    public int size(){ return N; }

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{

        private Node a = top;

        @Override
        public boolean hasNext() { return a != null;}

        @Override
        public Item next() {
            Item res = a.item;
            a = a.next;
            return res;
        }
        
        @Override
        public void remove() {}
        
    }


}
