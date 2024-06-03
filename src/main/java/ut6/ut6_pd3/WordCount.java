package ut6.ut6_pd3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {
    private Map<String, Integer> map;

    public WordCount() {
        map = new HashMap<>();
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void clear() {
        map.clear();
    }

    public void addWords(String line) {
        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    public String convertMap() {
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER))
                .forEach(entry -> sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));
        return sb.toString();
    }

    public static void main(String[] args) {
        WordCount wc = new WordCount();

        try {
            URL url = new URL(args[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                wc.addWords(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(wc.convertMap());
    }
}

