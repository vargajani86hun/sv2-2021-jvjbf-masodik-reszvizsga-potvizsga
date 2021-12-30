package filemanipulation;

public class Product {
    private String idNumber, name;
    private int price;

    public Product(String idNumber, String name, int price) {
        this.idNumber = idNumber;
        this.name = name;
        this.price = price;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return idNumber + ";" + name + ";" +price;
    }
}
