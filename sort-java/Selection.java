import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {

    /*
    * 选择排序在集合中选择最小（大）的值，放在最左边
    * 这样最左边就是有序的
    * 选择排序的第一层循环，不断地缩小第二轮循环的选择范围
    * 选的排序的思想比较简单，时间复杂度为O^2
    * 不管集合本身的数据排序情况怎么样，都不会影响时间复杂度
    * */

    public static void sort(Comparable[] a){
        int N = a.length;

        for (int i = 0; i < N; i++) {
            //先假设第当前选择区间第一个元素就是最小的
            int min = i;
            for (int j = i+1; j < N; j++) {
                //从选择区间的第一个遍历到最后一个，选出来最小的
                if(less(a[j], a[min]))
                    min = j; //如果当前元素比比对元素小，更新min
            }
            //内层一论循环完成就选出来了选择区间内的最小值的下标
            exch(a,i,min);//根据下标交换
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
