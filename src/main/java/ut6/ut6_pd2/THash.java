package ut6.ut6_pd2;

import java.util.LinkedList;

public class THash implements IHash {
    private LinkedList<Integer>[] table;
    private int size;
    private int comparisonsInsert;
    private int comparisonsSuccessfulSearch;
    private int comparisonsUnsuccessfulSearch;
    private int insertCount;
    private int successfulSearchCount;
    private int unsuccessfulSearchCount;

    @SuppressWarnings("unchecked")
    public THash(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
        comparisonsInsert = 0;
        comparisonsSuccessfulSearch = 0;
        comparisonsUnsuccessfulSearch = 0;
        insertCount = 0;
        successfulSearchCount = 0;
        unsuccessfulSearchCount = 0;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return unaClave % table.length;
    }

    @Override
    public int insertar(int unaClave) {
        int index = funcionHashing(unaClave);
        LinkedList<Integer> list = table[index];
        comparisonsInsert++;
        if (!list.contains(unaClave)) {
            list.add(unaClave);
            size++;
        }
        insertCount++;
        return comparisonsInsert;
    }

    @Override
    public int buscar(int unaClave) {
        int index = funcionHashing(unaClave);
        LinkedList<Integer> list = table[index];
        for (int k : list) {
            comparisonsSuccessfulSearch++;
            if (k == unaClave) {
                successfulSearchCount++;
                return comparisonsSuccessfulSearch;
            }
        }
        comparisonsUnsuccessfulSearch++;
        unsuccessfulSearchCount++;
        return comparisonsUnsuccessfulSearch;
    }

    public int getSize() {
        return size;
    }

    public double getLoadFactor() {
        return (double) size / table.length;
    }

    public double getAverageComparisonsInsert() {
        return (double) comparisonsInsert / insertCount;
    }

    public double getAverageComparisonsSuccessfulSearch() {
        return (double) comparisonsSuccessfulSearch / successfulSearchCount;
    }

    public double getAverageComparisonsUnsuccessfulSearch() {
        return (double) comparisonsUnsuccessfulSearch / unsuccessfulSearchCount;
    }
}
