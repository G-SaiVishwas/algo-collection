package dsalgo.datastructure.stack;

import dsalgo.datastructure.linkedlist.EmptyLinkedList;
import dsalgo.datastructure.linkedlist.MyLinkedList;

public class MyStack<E>{
    MyLinkedList<E> ll = new MyLinkedList<>();

    public void push(E data){
        ll.addFirst(data);
    }

    public E pop() throws EmptyLinkedList {
        return ll.removeLast();
    }

    public E peek() throws EmptyLinkedList {
        return ll.getLast();
    }

    public void print() throws EmptyLinkedList {
        ll.print();
    }
}
