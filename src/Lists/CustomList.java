package Lists;

import java.util.Iterator;

public class CustomList<C> implements Iterable<C> {
    public CustomNode<C> head = null;
    private int size = 0;

    public void addItem(C e) {
        size++;
        CustomNode<C> cn = new CustomNode<>();
        cn.setContents(e);
        cn.next = head;
        head = cn;
    }

    @Override
    public Iterator<C> iterator() {
        return new CustomIterator<>(head);
    }

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

    public C get2(int index) {
        CustomNode<C> current = head;
        int i = 0;
        while (current != null && i++ < index) current = current.next;
        return current == null ? null : current.getContents();
    }

    public void remove(int index) {
        CustomNode current = head, prev = null;
        int i = 0;
        if (index == 0) head = head.next;
        else {
            while (current != null && i != index) {
                prev = current;
                current = current.next;
                i++;
            }
            if (current != null) {
                prev.next = current.next;
            }
        }
        size--;
    }

    public int getSize() {
        return size;
    }
}