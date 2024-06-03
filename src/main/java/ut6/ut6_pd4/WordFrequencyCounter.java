package ut6.ut6_pd4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordFrequencyCounter <input-file>");
            return;
        }

        String fileName = args[0];
        Map<String, Integer> wordFrequencies = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                addWords(line, wordFrequencies);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Graficar los resultados de las 10 palabras que más ocurren
        plotMostFrequentWords(wordFrequencies);
    }

    private static void addWords(String line, Map<String, Integer> wordFrequencies) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }
    }

    private static void plotMostFrequentWords(Map<String, Integer> wordFrequencies) {
        // Convertir el mapa a una lista de pares (palabra, frecuencia)
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequencies.entrySet());
        
        // Ordenar la lista en orden descendente de frecuencia
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Tomar las primeras 10 palabras más frecuentes
        List<Map.Entry<String, Integer>> top10 = entries.subList(0, Math.min(10, entries.size()));

        // Graficar las palabras y sus frecuencias
        for (Map.Entry<String, Integer> entry : top10) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

