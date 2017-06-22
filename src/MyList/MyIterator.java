package MyList;

import java.util.Iterator;

public class MyIterator implements Iterator {
    private MyList list;

    public MyIterator(MyList list) {
        this.list = list;
    }
    private int index;

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Object next() {
        Object o = list.get(index);
        index++;
        return o;
    }
}
