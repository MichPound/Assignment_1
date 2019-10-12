package Lists;

import java.util.Iterator;

public class CustomList<C> implements Iterable<C> {
    public CustomNode<C> head = null;

    public void addItem(C e){
        CustomNode<C> cn = new CustomNode<>();
        cn.setContents(e);
        cn.next = head;
        head = cn;
    }

    @Override
    public Iterator<C> iterator(){
        return new CustomIterator<>(head);
    }

    public void clear(){
        head = null;
    }

}