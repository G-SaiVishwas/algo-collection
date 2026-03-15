package dsalgo.datastructure.queue;

import dsalgo.datastructure.linkedlist.EmptyLinkedList;
import dsalgo.datastructure.linkedlist.MyLinkedList;

public class MyQueue<E> {
    MyLinkedList<E> ll = new MyLinkedList<>();

    public void enqueue(E data){
        ll.addFirst(data);
    }

    public E dequeue() throws EmptyLinkedList {
        return ll.removeFirst();
    }

    public void print() throws EmptyLinkedList {
        ll.print();
    }
}
