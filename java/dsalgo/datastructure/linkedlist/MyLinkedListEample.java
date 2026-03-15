package dsalgo.datastructure.linkedlist;

public class MyLinkedListEample {
    public static void main(String[] args) throws EmptyLinkedList {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        for (int i = 1; i <=10; i++) {
            ll.addLast(i);
        }
        ll.addFirst(11);
        ll.addFirst(12);
        ll.removeFirst();
        ll.removeFirst();
        ll.removeLast();
        ll.removeLast();
        ll.removeLast();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        ll.print();
    }
}
