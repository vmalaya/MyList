package MyList;


import java.util.*;

public class MyList implements List{
    private  Node head;
    private  Node tail;
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
        if(node != null) {
            while (node != null) {
                System.out.println(node.value.toString());
                node = node.next;
            }
        }else{
            System.out.println("List is empty!");
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
        if(head.value.equals(o)){
            return true;
        }
        if(tail.value.equals(o)){
            return  true;
        }
        Node node = head;
        while (node.next != null){
            if (node.next.value.equals(o)){
                return true;
            }
            node = node.next;
        }

        return contained;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] array = new Object[size];
        Node node = head;
        while(node != null){
            array[index] = node.value;
            index++;
            node = node.next;
        }
        return array;
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
        boolean added = false;
        if(c instanceof  Object){
            for (Object o:c) {
                this.add(o);
            }
            added = true;
        }
        return added;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        int counter = 0;
        boolean added  = false;
        if(index == counter){
             this.addAll(c);
             added = true;
        }
        Node node = head;
        if(c instanceof  Object){
            while (node != null){
                counter++;
                if(counter == index){
                    for (Object o:c) {
                        int i = index;
                        this.add(i, o);
                        i++;
                    }
                    added = true;
                }
                node = node.next;
            }
        }
        return added;
    }

    @Override
    public void clear() {
        head.next = null;
        head = null;
        size = 0;

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
        Object o = new Object();
        if(index<size || ( size == 0 && index ==0)) {
            int counter = 0;
            Node node = head;
            while (node != null) {
                if (counter == index) {
                    o = node.value;
                    node.value = element;
                }
                counter++;
                node = node.next;
            }
        } else {
            System.out.println("Index out of list bounds");
        }
        return o;
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
       } else{
           System.out.println("There is not such index");
       }


    }

    @Override
    public Object remove(int index) {
        Object result = null;
        if(index < size || (size == 0 && index == 0)){
          int counter = 0;
          if(counter == index){
              result = head.value;
              head = head.next;
              size--;
              return result;
          }
          Node node = head;
          while (node!= null){
              counter++;
              if(counter == index){
                      result = node.next.value;
                      node.next = node.next.next;
                      size--;
                  }
              node = node.next;
              }
          } else{
            System.out.println("Index out of list bounds");
        }

        return result;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node node = head;
        if(head.value == (o)){
            return index;
        }
        while (node.next != null){
            index++;
            if(node.next.value.equals(o)){
                return  index;
            }
            node = node.next;

        }
        index = -1;

        return  index;
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
    public MyList subList(int fromIndex, int toIndex) {
        MyList newList = new MyList();
        if(toIndex < size){
            Node node = head;
            int count = 0;
            while(node != null) {
                int i = count;
                if(count == fromIndex){
                        while (i <= toIndex) {
                            Object o = this.get(i);
                            newList.add(o);
                            i++;
                        }

                }
                    count++;
                    node = node.next;
            }
        } else {
            System.out.println("Index out of list bounds");
        }
        return newList ;
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
