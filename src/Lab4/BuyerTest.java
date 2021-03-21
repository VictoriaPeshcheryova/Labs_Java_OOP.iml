package Lab4;

import Lab3.Buyer;
import Lab3.EnumsForSortingCatalogByField.SortingCatalogByField;
import Lab3.Product;
import Lab3.Shop;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {


    @Test
    void testAddTheProductToTheBasket() {
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true)
        };
        Shop shop=new Shop();
        shop.addTheProductToTheCatalog(listOfProduct);
        Buyer Carson=new Buyer("12fdfg21","24246");
        Carson.addTheProductToTheBasket("Watch 8.6");
        String expected="[Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=false}]";
        Assert.assertEquals(expected,Carson.printMyBasket());
    }

    @Test
    void testDeleteTheProductFromTheBasket() {
        Shop shop=new Shop();
        ArrayList<Product> catalog =new ArrayList<>();
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
        shop.addTheProductToTheCatalog(listOfProduct);
        Buyer Carson=new Buyer("12fdfg21","24246");
        Carson.addTheProductToTheBasket("Watch 8.6");
        boolean expected=Carson.deleteTheProductFromTheBasket("Watch 8.6");
        assertTrue(expected);
    }

    @Test
    void testSearchItemInMyBasketName() {
        Shop shop=new Shop();
        ArrayList<Product> catalog =new ArrayList<>();
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
        shop.addTheProductToTheCatalog(listOfProduct);
        Buyer Carson=new Buyer("12fdfg21","24246");
        Carson.addTheProductToTheBasket("Smart TV");
        assertEquals(true,Carson.searchItemInMyBasketName("Smart TV"));

    }

    @Test
    void testSearchItemInMyBasketCompanyName() {
        Shop shop=new Shop();
        ArrayList<Product> catalog =new ArrayList<>();
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
        shop.addTheProductToTheCatalog(listOfProduct);
        Buyer Carson=new Buyer("12fdfg21","24246");
        Carson.addTheProductToTheBasket("Samsung");
        assertEquals(true,Carson.searchItemInMyBasketCompanyName("Samsung"));

    }

    @Test
    void testSearchItemInMyBasketPrice() {
        Shop shop=new Shop();
        ArrayList<Product> catalog =new ArrayList<>();
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
        shop.addTheProductToTheCatalog(listOfProduct);
        Buyer Carson=new Buyer("12fdfg21","24246");
        Carson.addTheProductToTheBasket("Smart TV");
        assertEquals(true,Carson.searchItemInMyBasketPrice(33000));

    }

    @Test
    void testSortingByField() {
        Shop shop=new Shop();
        ArrayList<Product> catalog =new ArrayList<>();
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
        shop.addTheProductToTheCatalog(listOfProduct);
        Buyer Carson=new Buyer("12fdfg21","24246");
        Carson.addTheProductToTheBasket("Watch 3.6");
        Carson.addTheProductToTheBasket("Smart TV");
        Carson.SortingByField(SortingCatalogByField.NAME);
        String expected="[Product{nameOfTheProduct='Smart TV', companyNameOfAProduct='Samsung', priceOfAProduct=33000, amountOfProductInStock=false}, " +
                "Product{nameOfTheProduct='Watch 3.6', companyNameOfAProduct='Huawei', priceOfAProduct=5000, amountOfProductInStock=false}]";
        assertEquals(expected,Carson.printMyBasket());
    }

    @Test
    void testPrintMyBasket() {
        Product[]  listOfProduct =new Product[]{new Product("Watch 8.6","Meizu",3000,true)
        };
        Shop shop=new Shop();
        shop.addTheProductToTheCatalog(listOfProduct);
        Buyer Carson=new Buyer("12fdfg21","24246");
        Carson.addTheProductToTheBasket("Watch 8.6");
        String expected="[Product{nameOfTheProduct='Watch 8.6', companyNameOfAProduct='Meizu', priceOfAProduct=3000, amountOfProductInStock=false}]";
        Assert.assertEquals(expected,Carson.printMyBasket());
    }
}