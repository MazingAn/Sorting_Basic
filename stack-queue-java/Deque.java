import java.util.Iterator;
import java.util.NoSuchElementException;

/*
* 一个两头出的列队，使用链表实现
* first为最右边，last为最左边
* 最早入队的放在last，最后入队的放在left
* */

public class
Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public Deque() {
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        if(item == null)
            throw new IllegalArgumentException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if(last == null) last=first;
        else oldFirst.prev = first;
        N++;
    }

    public void addLast(Item item) {
        if(item == null)
            throw new IllegalArgumentException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if(first == null) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = first.item;
        if(N > 1){
            first = first.next;
            first.prev = null;
        }else{
            first = last = null;
        }
        N--;
        return item;
    }

    public Item removeLast() {
        if(isEmpty())
            throw new NoSuchElementException();
        Item item = last.item;
        if(N > 1){
            last = last.prev;
            last.next = null;
        }else{
            last = first = null;
        }
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
       return new Iterator<Item>() {
           private Node current = first;
           @Override
           public boolean hasNext() {
               return current != null;
           }

           @Override
           public Item next() {
               if (current == null)
                   throw new NoSuchElementException();
               Item item = current.item;
               current = current.next;
               return item;
           }

           @Override
           public void remove() {
               throw  new UnsupportedOperationException();
           }
       };
    }


    public static void main(String[] args) { }
}
