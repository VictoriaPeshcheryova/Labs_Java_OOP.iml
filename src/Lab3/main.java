package Lab3;

import Lab3.EnumsForSortingCatalogByField.SortingCatalogByField;

import java.util.List;

public class main
{
    public static void main(String[] args) throws Exception {

        Product[]  listOfProducts =new Product[]{new Product("Watch 8.6","Meizu",3000,true),
                new Product("Iphone","Apple CO",12000,false),
                new Product("Smart TV","Samsung",33000,true),
                new Product("Watch 3.6","Huawei",5000,true)
        };
        Shop shop=new Shop();
        shop.addTheProductToTheCatalog(listOfProducts);
        System.out.println(shop.printTheCatalog());
        Buyer Edward=new Buyer("Ed2354","2342h");
        Edward.addTheProductToTheBasket("Watch 3.6");
        Edward.addTheProductToTheBasket("Smart TV");
        System.out.println(Edward.printMyBasket());
        Edward.SortingByField(SortingCatalogByField.NAME);
        System.out.println(Edward.printMyBasket());
        Edward.searchItemInMyBasketName("Smart TV");
        Edward.searchItemInMyBasketCompanyName("Huawei");
        Edward.searchItemInMyBasketPrice(33000);
    }
}
