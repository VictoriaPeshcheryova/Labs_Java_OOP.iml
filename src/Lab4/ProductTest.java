package Lab4;

import Lab3.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getNameOfTheProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        String expected="Iphone";
        assertEquals(expected,product.getNameOfTheProduct());
    }

    @Test
    void getCompanyNameOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        String expected="Apple";
        assertEquals(expected,product.getCompanyNameOfAProduct());
    }

    @Test
    void getPriceOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        int expected=20000;
        assertEquals(expected,product.getPriceOfAProduct());
    }

    @Test
    void getIsAvailable() {
        Product product=new Product("Iphone","Apple",20000,true);
        boolean expected=true;
        assertEquals(expected,product.getIsAvailable());
    }

    @Test
    void setNameOfTheProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setNameOfTheProduct("Watch 1.0");
        assertEquals("Watch 1.0",product.getNameOfTheProduct());
    }

    @Test
    void setCompanyNameOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setCompanyNameOfAProduct("Samsung");
        assertEquals("Samsung",product.getCompanyNameOfAProduct());
    }

    @Test
    void setPriceOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setPriceOfAProduct(30000);
        assertEquals(30000,product.getPriceOfAProduct());
    }

    @Test
    void setAmountOfProductInStock() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setAmountOfProductInStock(false);
        assertEquals(false,product.getIsAvailable());
    }
}