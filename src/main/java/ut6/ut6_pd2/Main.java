package ut6.ut6_pd2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int capacity = 1000;
        String filePathInsert = "claves_insertar.txt";
        String filePathSearch = "claves_buscar.txt";
        
        List<Integer> keysToInsert = readKeysFromFile(filePathInsert);
        List<Integer> keysToSearch = readKeysFromFile(filePathSearch);

        double[] loadFactors = {0.70, 0.75, 0.80, 0.85, 0.90, 0.91, 0.92, 0.93, 0.94, 0.95, 0.96, 0.97, 0.98, 0.99};
        System.out.printf("%-15s %-30s %-30s %-30s%n", "Factor de carga", "Prom. Comparaciones Inserción", "Prom. Comp. Búsqueda exitosa", "Prom. Comp. Búsqueda sin éxito");

        for (double loadFactor : loadFactors) {
            THash hashTable = new THash(capacity);
            int elementsToInsert = (int) (capacity * loadFactor);

            // Insertar elementos hasta alcanzar el factor de carga deseado
            for (int i = 0; i < elementsToInsert; i++) {
                hashTable.insertar(keysToInsert.get(i));
            }

            // Realizar búsquedas (mitad exitosas, mitad no exitosas)
            for (int i = 0; i < elementsToInsert / 2; i++) {
                hashTable.buscar(keysToSearch.get(i)); // Búsquedas exitosas
            }
            for (int i = elementsToInsert / 2; i < elementsToInsert; i++) {
                hashTable.buscar(keysToInsert.get(capacity - i - 1)); // Búsquedas no exitosas
            }

            System.out.printf("%-15.2f %-30.2f %-30.2f %-30.2f%n",
                    loadFactor * 100,
                    hashTable.getAverageComparisonsInsert(),
                    hashTable.getAverageComparisonsSuccessfulSearch(),
                    hashTable.getAverageComparisonsUnsuccessfulSearch());
        }
    }

    private static List<Integer> readKeysFromFile(String filePath) {
        List<Integer> keys = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                keys.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keys;
    }
}
