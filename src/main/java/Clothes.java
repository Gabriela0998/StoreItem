import java.time.DayOfWeek;
import java.time.LocalDate;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Clothes extends StoreItem implements Taxable, Expirable {
    String size;

    public Clothes(String name, String brandName, double price, String size) {
        super(name, brandName, price);
        this.size = size;
    }

    @Override
    public boolean doesExpire() { // By default, yes, most beverages would expire
        return true;
    }

    @Override
    public double getWithDiscount() {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (dayOfWeek.getValue()==6 || dayOfWeek.getValue()==7){
            return price;
        }else{
            price = price - (price * (10.0 / 100.0)) ;
        }

        return price;
    }


    @Override
    public String toString() {
        return "Дрехи" +
                "\nИме: " + name
                + "\nМарка: " + brand
                + "\nЦена: $" + price
                + "\n\n";
    }
}