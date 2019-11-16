package Lists;

import java.util.Iterator;

public class CustomIterator<K> implements Iterator<K> {

    private CustomNode<K> pos;

    public CustomIterator(CustomNode<K> cnode) {
        pos = cnode;
    }

    @Override
    public boolean hasNext() {
        return pos != null;
    }

    @Override
    public K next() {
        CustomNode<K> temp = pos;
        pos = pos.next;
        return temp.getContents();
    }
}
