package Lists;

import java.util.Iterator;

public class CustomList<C> implements Iterable<C> {
    public CustomNode<C> head = null;

    public void addItem(C e) {
        CustomNode<C> cn = new CustomNode<>();
        cn.setContents(e);
        cn.next = head;
        head = cn;
    }

    @Override
    public Iterator<C> iterator() {
        return new CustomIterator<>(head);
    }

    public void clear() {
        head = null;
    }


    //    public Object get(int index) {
//        if (index < 0)
//            return null;
//        CustomNode current = null;
//        if (head != null) {
//            current = head;
//            if (index == 0)
//                return current;
//            else {
//                for (int i = 1; i < index; i++) {
//                    if (current.next == null)
//                        return null;
//                    current = current.next;
//                }
//                return current.getContents();
//            }
//        }
//        return null;
//    }
//}
    public Object get(int index) {
        if (index < 0)
            return null;
        CustomNode current = null;
        if (head != null) {
            current = head;
            if (index == 0)
                return current;
            else {
                for (int i = 1; i < index; i++) {
                    if (current.next != null)
                    current = current.next;
                }
                return current;
            }
        }
        return null;
    }
}