/*
 *比较常用的，使用数组实现的Stack，支持泛型与iterator
 * */
import java.util.Iterator;

public class Stack implements Iterator<Item> {

    private Item[] s;
    private int N = 0;

    @Override
    public boolean hasNext() {
        return N > 0;
    }

    @Override
    public Item next() {
        return s[--N];
    }

    @Override
    public void remove() {
        //do nothing
    }

    public void Stack(){
        //遗憾的是java不允许创建泛型数组，所以在这里只有进行类型转换
        //这里编译器会发出警报，但是没办法，只能对编译器say sorry了
        this.s = (Item[]) new Object[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item item){
        if(N == s.length) resize(s.length * 2);
        s[N++] = item;
    }

    public Item pop(){
        Item item = s[--N];
        s[N] = null;
        if(N > 0 && N == s.length/4 ) resize(s.length / 2);
        return item;
    }

    private void resize(int target_size){
        Item[] copy = (Item[]) new Object[target_size];
        for (int i = 0; i < N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }
}
