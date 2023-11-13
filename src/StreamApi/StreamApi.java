package StreamApi;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {

    public List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() > 250)
                .collect(Collectors.toList());
    }


    public List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.isDiscountAvailable())
                .map(p -> {
                    p.setPrice(p.getPrice() * 0.9); // Застосовуємо знижку 10%
                    return p;
                })
                .collect(Collectors.toList());
    }


    public Product findCheapestBook(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Продукт [категорія: Book] не знайдено"));
    }


    public List<Product> getLatestProducts(List<Product> products, int count) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getAddDate).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }


    public double calculateTotalCost(List<Product> products) {
        int currentYear = LocalDate.now().getYear();
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() <= 75 && p.getAddDate().getYear() == currentYear)
                .mapToDouble(Product::getPrice)
                .sum();
    }


    public Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
