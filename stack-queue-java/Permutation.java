import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> sq = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            sq.enqueue(item);
        }
        for (int i = 0; i < k; i ++)
            StdOut.println(sq.dequeue());
    }

}
