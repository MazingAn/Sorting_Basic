import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {

    /*
    * 插入排序的思想就像是整理手上的牌，保证手里的牌是有序的，新加入的牌插入到合适的位置就好
    * 每拿到一个新的元素，就和左侧了；临近的元素比较，如果小于则交换，否则直接跳出
    * 插入排序的优点在于能够提前跳出第二层循环
    * 如果集合本身就是近似有序的，算法的效率会高很多
    * */

    public static void sort(Comparable[] a){
        int N = a.length;

        //最左边的第一个牌是手牌，只有一张，每次接牌之后都会把新牌放入到合适的位置，
        // 从而确保左侧手牌始终有序
        for (int i = 1; i < N; i++) {
            //然后从右侧开始揭牌，从左往右和手里的牌比较
            for(int j = i; j > 0; j--) {
                //挨个比较，如果小就交换位置，如果大那当前位置就是合适的位置
                if(less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else
                    break;
            }
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args){
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
