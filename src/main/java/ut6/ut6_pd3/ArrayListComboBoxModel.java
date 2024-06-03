package ut6.ut6_pd3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListComboBoxModel extends AbstractListModel<String> implements MutableComboBoxModel<String> {
    private List<String> items;
    private Object selectedItem;

    public ArrayListComboBoxModel() {
        this.items = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public String getElementAt(int index) {
        return items.get(index);
    }

    @Override
    public void addElement(String element) {
        items.add(element);
        fireIntervalAdded(this, items.size() - 1, items.size() - 1);
    }

    @Override
    public void removeElement(Object element) {
        int index = items.indexOf(element);
        if (index != -1) {
            items.remove(index);
            fireIntervalRemoved(this, index, index);
        }
    }

    @Override
    public void insertElementAt(String element, int index) {
        items.add(index, element);
        fireIntervalAdded(this, index, index);
    }

    @Override
    public void removeElementAt(int index) {
        items.remove(index);
        fireIntervalRemoved(this, index, index);
    }

    @Override
    public void setSelectedItem(Object item) {
        selectedItem = item;
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
