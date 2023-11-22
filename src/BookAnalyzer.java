import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
public class BookAnalyzer {
    private Scanner scanner;

    public BookAnalyzer() {
        scanner = new Scanner(System.in);
    }

    public void run() {

        System.out.print("Enter the book title: ");
        String bookName = scanner.nextLine();
        Path bookPath = Paths.get("src", bookName);
        if (!Files.exists(bookPath) || !Files.isRegularFile(bookPath)) {
            System.out.println("Book not found in the project directory.");
            return;
        }
        try {

            String bookContent = new String(Files.readAllBytes(bookPath));
            List<String> words = Arrays.asList(bookContent.split("\\s+"));
            Map<String, Long> wordFrequency = words.stream()
                    .filter(word -> word.length() > 2)
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

            Path statisticFilePath = Paths.get(bookName + "_statistic.txt");
            try (PrintWriter writer = new PrintWriter(statisticFilePath.toFile())) {
                wordFrequency.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(10)
                        .forEach(entry -> writer.println(entry.getKey() + " -> " + entry.getValue()));

                writer.println("\nTotal number of words: " + wordFrequency.size());
            }

            System.out.println("Statistics successfully generated:");
            wordFrequency.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        } catch (IOException e) {
            System.out.println("Error reading/writing the file: " + e.getMessage());
        }
    }
}
