import java.time.DayOfWeek;
import java.time.LocalDate;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Appliances extends StoreItem implements Taxable, Expirable {
    String model;
    LocalDate productDate;
    Double weight;

    public Appliances(String name, String brandName, double price, String model,LocalDate productDate, Double weight) {
        super(name, brandName, price);
        this.model = model;
        this.productDate = productDate;
        this.weight = weight;
    }

    @Override
    public boolean doesExpire() { // By default, yes, most beverages would expire
        return true;
    }

    @Override
    public double getWithDiscount() {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if ((dayOfWeek.getValue()==6 || dayOfWeek.getValue()==7) && price>999.0){
            price = price - (price * (5.0 / 100.0)) ;
        }
        return price;
    }


    @Override
    public String toString() {
        return "ТЕХНИКА" +
                "\nИме: " + name
                + "\nМарка: " + brand
                + "\nЦена: $" + price
                + "\n\n";
    }
}