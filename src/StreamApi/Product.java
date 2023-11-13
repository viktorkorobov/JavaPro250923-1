package StreamApi;
import java.time.LocalDate;
public class Product {
    private String type;
    private double price;
    private boolean discountAvailable;
    private LocalDate addDate;

    public Product(String type, double price, boolean discountAvailable, LocalDate addDate) {
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discountAvailable=" + discountAvailable +
                ", addDate=" + addDate +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscountAvailable() {
        return discountAvailable;
    }

    public void setDiscountAvailable(boolean discountAvailable) {
        this.discountAvailable = discountAvailable;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
