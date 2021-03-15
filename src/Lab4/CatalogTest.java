package Lab4;

import Lab3.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {
    protected static ArrayList<Product> catalog=new ArrayList<>();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    void addTheProductToTheCatalog() {
        Product product=new Product("Watch 8.6","Meizu",3000,86);
        ArrayList<Product> expected=new ArrayList<>();
        expected.add(product);
        catalog.add(product);
        assertArrayEquals(catalog.toArray(), expected.toArray());
    }

    @Test
    void deleteTheProductFromTheCatalog() {
        Product product=new Product("Watch 8.6","Meizu",3000,86);
        String name=product.getNameOfTheProduct();
        catalog.add(product);
        ArrayList<Product> expected=new ArrayList<>();
        expected.add(product);
        catalog.removeIf(productItem -> product.getNameOfTheProduct().equals(name));
        expected.removeIf(productItem -> product.getNameOfTheProduct().equals(name));
        assertArrayEquals(catalog.toArray(), expected.toArray());
    }

    @Test
    void printTheCatalog() {
        Product product=new Product("Watch 8.6","Meizu",3000,86);
        catalog.add(product);
        System.out.println(catalog);
        assertEquals("[Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=86}]", catalog.toString());
    }

}