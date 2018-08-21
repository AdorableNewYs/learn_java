public class Steque<Item> {

    private class Node{
        Item item;
        Node next;
    }

    private Node first,last;
    private int N;

    public int size(){ return N; }

    public boolean isEmpty(){ return N == 0; }

    public void push(Item s){
        Node oldFirst = first;
        first = new Node();
        first.item = s;
        if(isEmpty()) last = first;
        else first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item res = first.item;
        first = first.next;
        N--;
        if(isEmpty()) last = null;
        return res;
    }

    public void enQueue(Item s){
        if(isEmpty()) push(s);
        else {
            Node oldLast = last;
            last = new Node();
            last.item = s;
            oldLast.next = last;
            N++;
        }
    }

}
