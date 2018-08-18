import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int N = 0;
    private Item[] s;

    public Deque() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item)throws IllegalArgumentException {
        moveLeft();
        if(N++ == s.length)
            resize(s.length * 2);
        s[0] = item;
    }

    public void addLast(Item item) throws IllegalArgumentException {
        if(N == s.length)
            resize(s.length * 2);
        s[N++] = item;
    }

    public Item removeFirst() throws NoSuchElementException {
        Item item = s[0];
        moveRight();
        if(N > 0 && N == s.length/4)
            resize(s.length / 4);
        N--;
        return item;
    }

    public Item removeLast() throws NoSuchElementException {
        Item item = s[--N];
        if(N > 0 && N == s.length/4)
            resize(s.length / 4);
        s[N] = null;
        return item;
    }

    public Iterator<Item> iterator(){
       return new Iterator<Item>() {
           @Override
           public boolean hasNext() {
               return N > 0;
           }

           @Override
           public Item next() throws NoSuchElementException{
               return s[--N];
           }

           @Override
           public void remove() {
               throw  new UnsupportedOperationException();
           }
       };
    }

    private void resize(int size){
        Item[] copy = (Item[])new Object[size];
        for (int i = 0; i < N; i++)
                copy[i] = s[i];
        s = copy;
    }

    private void moveLeft(){
        Item[] copy = (Item[])new Object[N+1];
        for (int i = 0; i < N; i++)
            copy[i+1] = s[i];
        s = copy;
    }


    private void moveRight(){
        Item[] copy = (Item[])new Object[N];
        for (int i = 1; i < N; i++)
            copy[i-1] = s[i];
        s = copy;
    }

    public static void main(String[] args) {

    }
}