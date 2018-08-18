import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int N = 0;
    private Item[] s;

    public RandomizedQueue() {
        this.s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) throws IllegalArgumentException {
        s[N++] = item;
        if(N == s.length)
            resize(s.length * 2);
    }

    public Item dequeue() {
        int rand = StdRandom.uniform(1,N);
        Item item = s[rand-1];
        if (rand == N){
            s[--N] = null;
        }else{
            move(rand);
            N--;
        }
        if(N > 0 && N== s.length / 4)
            resize(s.length/2);
        return item;
    }

    public Item sample() throws NoSuchElementException {
        int i = StdRandom.uniform(N);
        return s[i];
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return N > 0;
            }

            @Override
            public Item next() throws NoSuchElementException {
                return s[--N];
            }

            @Override
            public void remove(){
                throw  new UnsupportedOperationException();
            }
        };
    }

    private void resize(int size){
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    private void move(int rand){
        Item[] copy = (Item[]) new Object[N];
        for (int i = 0; i < rand-1; i++)
            copy[i] = s[i];
        for (int i = rand-1 ; i < N; i++)
            copy[i] = s[i + 1];
        s = copy;
    }

    public static void main(String[] args) {
    }
}