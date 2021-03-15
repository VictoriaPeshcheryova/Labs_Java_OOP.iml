package Lab4;

import Lab3.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    protected static ArrayList<Product> catalog=new ArrayList<>();
    protected static ArrayList<Product> basket=new ArrayList<>();

    @Test
    void TestDeleteTheProductFromTheBasket() {
        Product product=new Product("Watch 8.6","Meizu",3000,86);
        String name=product.getNameOfTheProduct();
        basket.add(product);
        ArrayList<Product> expected=new ArrayList<>();
        expected.add(product);
        basket.removeIf(productItem -> product.getNameOfTheProduct().equals(name));
        expected.removeIf(productItem -> product.getNameOfTheProduct().equals(name));
        assertArrayEquals(basket.toArray(), expected.toArray());
    }

    @Test
    void TestPrintMyBasket() {
        Product product=new Product("Watch 8.6","Meizu",3000,86);
        basket.add(product);
        System.out.println(basket);
        assertEquals("[Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=86}]", basket.toString());
    }
}