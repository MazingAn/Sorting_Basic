package com.andy.algorithms;

public class ArrayedStackofString {

    /*
    * 创建一个数组来存放元素
    * 栈顶就是数组当前的下标N
    * 如果push的时候数组不够用了，扩充数组到2倍
    * 如果pop的时候当前元素只有数组的1/4，删除数组后半部分
    * */

    private int N = 0;
    private String[] array;

    public void ArrayedStackofString(){
        array = new String[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        //如果N+1大于等于数组长度，数组扩充一倍
        if (N == array.length){
            resize(array.length * 2);
        }
        //在N+1的位置放入新的元素
        array[N++] = item;
    }

    public String pop(){

        //提取出来当前的item返回
        //设置N位置的元素为null，N减少1
        String item = array[--N];
        array[N] = null;
        //如果N是数组的1/4，删除数组后半部分
        if (N > 0 && N == array.length / 4)
            resize(array.length / 2);
        return item;
    }

    private void resize(int targetSize){
        String[] copy = new String[targetSize];
        for( int i = 0; i < N; i++)
            copy[i] = array[i];
        array = copy;
    }

}
