package StreamApi;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Book", 300, true, LocalDate.of(2023, 1, 1));
        Product product2 = new Product("Book", 200, false, LocalDate.of(2023, 2, 1));
        Product product3 = new Product("Toy", 150, true, LocalDate.of(2023, 3, 1));

        List<Product> productList = Arrays.asList(product1, product2, product3);

        StreamApi productManager = new StreamApi();

        List<Product> expensiveBooks = productManager.getExpensiveBooks(productList);
        System.out.println("Expensive books: " + expensiveBooks);

        List<Product> discountedBooks = productManager.getDiscountedBooks(productList);
        System.out.println("Books with discount: " + discountedBooks);

        Product cheapestBook = productManager.findCheapestBook(productList);
        System.out.println("Cheapest book: " + cheapestBook);

        List<Product> latestProducts = productManager.getLatestProducts(productList, 2);
        System.out.println("Latest products: " + latestProducts);

        double totalCost = productManager.calculateTotalCost(productList);
        System.out.println("Total cost:" + totalCost);

        Map<String, List<Product>> groupedProducts = productManager.groupProductsByType(productList);
        System.out.println("Grouping products by type: " + groupedProducts);
    }
}
