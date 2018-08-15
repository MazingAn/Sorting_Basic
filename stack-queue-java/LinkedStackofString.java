public class LinkedStackofString {

    /*
    * 通过链表实现一个栈：
    * 栈的规律是后进先出，对应的有push、pop、isEmpty方法
    * */

    private Node top = null;

    public boolean isEmpty(){
        return top == null;
    }

    public String pop(){
        //先把栈顶元素取出来
        String item = top.item;
        //把栈顶的元素设置为下一个元素
        top = top.next;
        return item;
    }

    public void push(String item){
        //先保存当前的top
        Node oldtop = top;
        //创建新top，next指向老的top
        top = new Node();
        top.item = item;
        top.next = oldtop;
    }

    private class Node{
        private String item;
        private Node next;
    }

}
