package dsalgo.datastructure.queue;

import dsalgo.datastructure.linkedlist.EmptyLinkedList;
import revision.LinkedList.MyLinkedList;

public class MyQueue<E> {
    MyLinkedList<E> ll = new MyLinkedList<>();

    public void enqueue(E data){
        ll.add(data);
    }

    public E dequeue() throws EmptyLinkedList {
        return ll.remove(0);
    }

    public void print() throws EmptyLinkedList {
        ll.print();
    }
}
