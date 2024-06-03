package ut6.ut6_pd3;
import javax.swing.*;
import java.util.*;

public class SortedListModel extends AbstractListModel<String> {
    private SortedSet<String> model;

    public SortedListModel() {
        model = new TreeSet<>();
    }

    @Override
    public int getSize() {
        return model.size();
    }

    @Override
    public String getElementAt(int index) {
        return model.toArray(new String[0])[index];
    }

    public void add(String element) {
        if (model.add(element)) {
            fireContentsChanged(this, 0, getSize());
        }
    }

    public void addAll(String[] elements) {
        Collection<String> c = Arrays.asList(elements);
        model.addAll(c);
        fireContentsChanged(this, 0, getSize());
    }

    public void clear() {
        model.clear();
        fireContentsChanged(this, 0, getSize());
    }

    public boolean contains(String element) {
        return model.contains(element);
    }

    public String firstElement() {
        return model.first();
    }

    public Iterator<String> iterator() {
        return model.iterator();
    }

    public String lastElement() {
        return model.last();
    }

    public boolean removeElement(String element) {
        boolean removed = model.remove(element);
        if (removed) {
            fireContentsChanged(this, 0, getSize());
        }
        return removed;
    }
}

