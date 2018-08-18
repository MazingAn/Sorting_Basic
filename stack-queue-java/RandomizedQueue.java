import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    /*
    * 一个随机队列，使用数组实现，动态设置数组的大小
    * samp随机取出一个元素，不删除
    * dequeue随机取出来一个元素，并删除
    * 全程保持队列的随机性，迭代器每次迭代得到的列队顺序也不同
    * */

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

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if(N == s.length)
            resize(s.length * 2);
        s[N++] = item;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        int rand = StdRandom.uniform(0,N);
        Item item = s[rand];
        s[rand] = s[--N];
        s[N] = null;
        if(N > 0 && N == s.length / 4)
            resize(s.length/2);
        return item;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        int rand = StdRandom.uniform(0,N);
        return s[rand];
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = N;
            private final int[] rands = StdRandom.permutation(i);

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                if(i < 1) throw new NoSuchElementException();
                else if(i == N) return s[rands[--i]];
                else return s[rands[--i]];
            }

            @Override
            public void remove(){
                throw  new UnsupportedOperationException();
            }
        };
    }

    private void resize(int size){
        Item[] copy = (Item[]) new Object[size];
        for(int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    public static void main(String[] args){

    }

}
