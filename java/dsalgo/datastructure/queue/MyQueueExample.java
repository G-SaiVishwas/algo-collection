package dsalgo.datastructure.queue;

import dsalgo.datastructure.linkedlist.EmptyLinkedList;

public class MyQueueExample {
    public static void main(String[] args) throws EmptyLinkedList {
        MyQueue<Integer> q = new MyQueue<>();
        for (int i = 0; i < 5; i++) {
            q.enqueue(i);
        }
        q.dequeue();
        q.print();
        q.dequeue();
        q.print();
        q.dequeue();
        q.print();
    }
}
