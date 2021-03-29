package Lab4;

import Lab3.Product;
import Lab3.Shop;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)

class ShopTest  {
    protected static  ArrayList<Product> catalog =new ArrayList<>();

    @Test
    void  testAddTheProductToTheCatalog() {
         Shop shop=new Shop();
         ArrayList<Product> catalog =new ArrayList<>();
         Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
      boolean expected=shop.addTheProductToTheCatalog(listOfProduct);
      assertTrue(expected);
    }


    @Test
    void testDeleteTheProductFromTheCatalog() {
        Shop shop=new Shop();
        ArrayList<Product> catalog =new ArrayList<>();
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
        shop.addTheProductToTheCatalog(listOfProduct);
        boolean expected=shop.deleteTheProductFromTheCatalog("Iphone");
        assertTrue(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=true}]",
            "[Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=true}, " +
                    "Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=true}]",
            "[Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=true}, " +
                    "Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=true}, " +
                    "Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=true}]",
    })
    void testPrintTheCatalog(String string) {

       Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true)};
       Shop shop=new Shop();
       shop.addTheProductToTheCatalog(listOfProduct);
        assertEquals(shop.printTheCatalog(),string);

   }

}