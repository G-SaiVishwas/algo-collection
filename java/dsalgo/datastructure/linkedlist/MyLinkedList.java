package dsalgo.datastructure.linkedlist;

public class MyLinkedList<E> {

    Node<E> head;
    public static class Node<E>{
        public E data;
        public Node<E> next;

        public Node(E data){
            this.data = data;
            next = null;
        }
    }

    public void addFirst(E data){
        Node<E> newNode = new Node<>(data);

        if(head == null){
            head.data = data;
            head.next = null;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(E data) throws EmptyLinkedList {
        Node<E> newNode = new Node<>(data);

        if(head == null){
            //throw new EmptyLinkedList("LinkedList should not be empty while adding node to end of the LikedList");
            head = newNode;
            return;
        }

        Node<E> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public E removeFirst() throws EmptyLinkedList {
        Node<E> temp = head;

        if(head == null){
            throw new EmptyLinkedList("LinkedList should not be empty while removing node from front of the LikedList");
        }

        if(head.next == null){
            head = null;
            return temp.data;
        }
        E FirstData = head.data;
        head = temp.next;
        return FirstData;
    }

    public E removeLast() throws EmptyLinkedList {
        Node<E> removeNode = head;

        if(head == null ){
            throw new EmptyLinkedList("we can not remove data from Empty LinkedList ");
        }

        if(head.next == null){
            removeNode = head;
            head = null;
            return removeNode.data;
        }

        Node<E> temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        removeNode = temp.next;
        temp.next = null;
        return removeNode.data;
    }

    public E getFirst() throws EmptyLinkedList {
        Node<E> temp = head;

        if(head == null){
            throw new EmptyLinkedList("LinkedList should not be empty while getting data from front of the LikedList");
        }

        if(head.next == null){
            return temp.data;
        }
        E FirstData = head.data;
        return FirstData;
    }

    public E getLast() throws EmptyLinkedList {
        Node<E> removeNode = head;

        if(head == null ){
            throw new EmptyLinkedList("we can not get data from Empty LinkedList ");
        }

        if(head.next == null){
            removeNode = head;
            return removeNode.data;
        }

        Node<E> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public void print() throws EmptyLinkedList {
        Node<E> temp = head;

        if(head == null){
            throw new EmptyLinkedList("LinkedList should not be empty to print LL");
        }

//        if(head.next == null){
//            System.out.println(head.data + " ");
//            return;
//        }

        while(temp.next != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data);

    }
}
