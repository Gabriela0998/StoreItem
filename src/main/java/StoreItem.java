public abstract class StoreItem implements Comparable<StoreItem>, Expirable, Taxable {
    protected String name;
    protected String brand;
    protected double price;

    public StoreItem(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public boolean doesExpire() {
        return false;
    }


    @Override
    public String toString() {
        return "Име: " + name
                + "\nМарка: " + brand
                + "\nЦена: $" + price
                + "\n\n";
    }

    @Override
    public int compareTo(StoreItem otherItem) {
        int compareResult = this.name.compareTo(otherItem.name);

        if (compareResult == 0)
            return this.getName().compareTo(otherItem.getName());
        else
            return compareResult;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        return result;
    }
}
