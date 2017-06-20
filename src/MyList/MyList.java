package MyList;


import java.util.*;

public class MyList implements List{
    Node head;
    Node tail;
    private int size = 0;
    public class Node{
        private Object value;
        private Node next;
        public Node(Object o){
            this.next = null;
            this.value = o;
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public void print(){
        Node node = head;
        while (node != null){
            System.out.println(node.value.toString());
            node = node.next;
        }
    }

    @Override
    public boolean contains(Object o) {
        boolean contained = false;
        if(head == null){
            return  contained;
        }
        if(head == tail){
            if(head.value.equals(o)){
                return true;
            } else {
                return contained;
            }
        }
        if(head.value == o){
            return true;
        }
        if(tail.value == o){
            return  true;
        }
        Node node = head;
        while (node != null){
            if (node.next.value == o){
                return true;
            }
            node = node.next;
        }

        return contained;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        boolean added;
        Node node = new Node(o);
        if(head == null){
            head = node;
            tail = node;
            added = true;
        } else {
            tail.next = node;
            tail = node;
            added = true;
        }
        size++;
        return added;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        if(head == null){
            return removed ;
        }
        if (head == tail){
            head = null;
            tail = null;
            size--;
            return true;

        }
        if(head.value == o){
            head = head.next;
            size--;
            return true;
        }
        Node node = head;
        while(node != null){
            if(node.next.value == o){
                if(tail == node.next){
                    node.next = null;
                    tail = node;
                } else {
                    node.next = node.next.next;
                }
                size--;
                removed = true;
            }
            node = node.next;
        }
        return removed;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        Object result = null;
        int count = 0;
        if(head == null){
            return null;
        }
        if(index == count){
            return head.value;
        }
        Node node = head;
        while(node.next != null && count < size){
           count++;
           if (count == index){
               result = node.next.value;
           }
           node = node.next;
        }
        return result;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
       if(index < size || (size == 0 && index == 0)){
           int counter = 0;
           Node AddedNode = new Node(element);
           if(index == counter){
               if(head == null){
                   head = AddedNode;
                   tail = AddedNode;
               } else {
                   AddedNode.next = head;
                   head = AddedNode;
               }
               return;
           }
           Node node = head;
           while (node.next != null){
               counter++;
               if (counter == index){
                   AddedNode.next = node.next;
                   node.next = AddedNode;
               }
               node = node.next;
           }
           size++;
       }


    }

    @Override
    public Object remove(int index) {

        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
