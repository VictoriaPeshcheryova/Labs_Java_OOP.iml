package Lab4;

import Lab3.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getNameOfTheProduct() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        assertEquals("Watch 8.6",product.getNameOfTheProduct());
    }

    @Test
    void setNameOfTheProduct() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        product.setNameOfTheProduct("Watch 4.9");
        assertEquals("Watch 4.9",product.getNameOfTheProduct());
    }

    @Test
    void getCompanyNameOfAProduct() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        assertEquals("Meizu",product.getCompanyNameOfAProduct());
    }

    @Test
    void setCompanyNameOfAProduct() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        product.setCompanyNameOfAProduct("Apple");
        assertEquals("Apple",product.getCompanyNameOfAProduct());
    }

    @Test
    void getPriceOfAProduct() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        assertEquals(3000,product.getPriceOfAProduct());
    }

    @Test
    void setPriceOfAProduct() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        product.setPriceOfAProduct(800);
        assertEquals(800,product.getPriceOfAProduct());
    }

    @Test
    void getAmountOfProductInStock() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        assertEquals(86,product.getAmountOfProductInStock());
    }

    @Test
    void setAmountOfProductInStock() {
        Product product = new Product("Watch 8.6","Meizu",3000,86);
        product.setAmountOfProductInStock(90);
        assertEquals(90,product.getAmountOfProductInStock());
    }
}