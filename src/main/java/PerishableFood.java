import java.text.DecimalFormat;
import java.time.LocalDate;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class PerishableFood extends StoreItem implements Taxable, Expirable {
    private LocalDate expiresOn;

    public PerishableFood(String name, String brand, double price, LocalDate expiresOn) {
        super(name, brand, price);
        this.expiresOn = expiresOn;
    }

    @Override
    public boolean doesExpire() {
        return true;
    }

    public LocalDate getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(LocalDate expiresOn) {
        this.expiresOn = expiresOn;
    }

    @Override
    public double getWithDiscount() {
        if (expiresOn.plusDays(5).isAfter(LocalDate.now())) {
            price = price - (price * (10.0 / 100.0));
        }

        if (expiresOn.equals(LocalDate.now())) {
            price = price - (price * (50.0 / 100.0));
        }

        return price;
    }

    @Override
    public String toString() {
        return "НЕТРАЙНА ХРАНА" +
                "\nИме: " + name
                + "\nМарка: " + brand
                + "\nЦена: $" + price
                + "\n\n";
    }
}
