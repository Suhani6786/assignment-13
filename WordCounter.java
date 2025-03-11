import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        // Define input and output file names
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // HashMap to store word counts
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.toLowerCase(); // Convert to lowercase
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error reading the input file.");
            return;
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing the output file.");
        }
    }
}
