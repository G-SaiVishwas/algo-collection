package dsalgo.datastructure.stack;

import dsalgo.datastructure.linkedlist.EmptyLinkedList;

public class MyStackExample {
    public static void main(String[] args) throws EmptyLinkedList {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.print();
    }
}
