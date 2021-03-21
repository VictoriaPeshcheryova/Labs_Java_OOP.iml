package Lab4;

import Lab3.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testGetNameOfTheProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        String expected="Iphone";
        assertEquals(expected,product.getNameOfTheProduct());
    }

    @Test
    void testGetCompanyNameOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        String expected="Apple";
        assertEquals(expected,product.getCompanyNameOfAProduct());
    }

    @Test
    void testGetPriceOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        int expected=20000;
        assertEquals(expected,product.getPriceOfAProduct());
    }

    @Test
    void testGetIsAvailable() {
        Product product=new Product("Iphone","Apple",20000,true);
        boolean expected=true;
        assertEquals(expected,product.getIsAvailable());
    }

    @Test
    void testSetNameOfTheProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setNameOfTheProduct("Watch 1.0");
        assertEquals("Watch 1.0",product.getNameOfTheProduct());
    }

    @Test
    void testSetCompanyNameOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setCompanyNameOfAProduct("Samsung");
        assertEquals("Samsung",product.getCompanyNameOfAProduct());
    }

    @Test
    void testSetPriceOfAProduct() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setPriceOfAProduct(30000);
        assertEquals(30000,product.getPriceOfAProduct());
    }

    @Test
    void testSetAmountOfProductInStock() {
        Product product=new Product("Iphone","Apple",20000,true);
        product.setAmountOfProductInStock(false);
        assertEquals(false,product.getIsAvailable());
    }
}