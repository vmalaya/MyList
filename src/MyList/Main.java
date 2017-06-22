package MyList;


import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        Integer i1 = 45;
        Integer i2 =98;
        String str ="Str";
        list.add(i1);
        list.add(i2);
        list.add(str);
        list.print();
        System.out.println("---------");
        List list1 = new LinkedList();
        list1.add(new Integer(500));
        list1.add(new String("uuuu"));
        list.addAll(1, list1);
        list.print();
        System.out.println("------------");
        System.out.println(list.set(3, 100));
        MyList newList = list.subList(1, 3);
        newList.print();




    }
}
