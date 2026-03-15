package dsalgo.datastructure.stack;

import dsalgo.datastructure.linkedlist.EmptyLinkedList;
import revision.LinkedList.MyLinkedList;

public class MyStack<E>{
    MyLinkedList<E> ll = new MyLinkedList<>();

    public void push(E data){
        ll.add(data);
    }

    public E pop() throws EmptyLinkedList {
        return ll.remove();
    }

    public E peek() throws EmptyLinkedList {
        return ll.getLast();
    }

    public void print() throws EmptyLinkedList {
        ll.print();
    }
}
