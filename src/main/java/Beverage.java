public class Beverage extends StoreItem implements Taxable, Expirable {

    public Beverage(String foodName, String brandName, double price) {
        super(foodName, brandName, price);
    }

    @Override
    public boolean doesExpire() { // By default, yes, most beverages would expire
        return true;
    }

    @Override
    public double getWithDiscount() {
        return price;
    }
}

