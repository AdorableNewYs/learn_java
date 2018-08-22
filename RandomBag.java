
import Std.StdOut;
import Std.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    private Item[] items = (Item[]) new Object[1];
    private int N;

    public boolean isEmpty(){ return N == 0; }

    public int size(){ return N; }

    public void add(Item item){
        items[N++] = item;
        if(N == items.length){
            Item[] newItems = (Item[]) new Object[2 * items.length];
            for(int i = 0; i < items.length ; i++) newItems[i] = items[i];
            items = newItems;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item>{

        private int[] rand = new int[N];
        private int i;
        public RandomBagIterator(){
            for(int i = 0; i < N;i++){
                rand[i] = i;
            }
            StdRandom.shuffle(rand);
        }


        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            return items[rand[i++]];
        }

        @Override
        public void remove() { }
    }

    public static void main(String[] args){
        RandomBag<Integer> s = new RandomBag<>();
        for(int i = 0; i < 50;i++) s.add(i);
        for(Integer i : s) StdOut.print(i + " ");
        StdOut.println();
        StdOut.println(s.size());
    }

}
