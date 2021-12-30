package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    private List<Product> products = new ArrayList<>();

    public void readProductsFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            readProductsFromString(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writePriceOverToFile(Path path, int minPrice) {
        try {
            Files.write(path, collectPriceOverToList(minPrice));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    private void readProductsFromString(List<String> lines) {
        for (String s : lines) {
            String[] tmp = s.split(";");
            products.add(new Product(tmp[0], tmp[1], Integer.parseInt(tmp[2])));
        }
    }

    private List<String> collectPriceOverToList(int minPrice) {
        List<String> results = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() > minPrice) {
                results.add(p.toString());
            }
        }
        return results;
    }
}
