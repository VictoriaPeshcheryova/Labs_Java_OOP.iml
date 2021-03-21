package Lab4;

import Lab3.Buyer;
import Lab3.Product;
import Lab3.Shop;
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
    void deleteTheProductFromTheBasket() {
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
    void searchItemInMyBasketName() {
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
    void searchItemInMyBasketCompanyName() {
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
    void searchItemInMyBasketPrice() {
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
    void sortingByField() {

    }

    @Test
    void printMyBasket() {
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