package Lab3;

import static Lab3.ActionsWithCatalog.SortingTheCatalogByField.SortingByField;
import static Lab3.Basket.*;
import static Lab3.EnumsForSortingCatalogByFields.SortingCatalogByField.*;

public class main
{
/*
Використовуйте колекції, графічний інтерфейс не потрібен.
Взаємодію з користувачем демонструвати не потрібно.

Створіть модель яка б відображала роботу інтернет-магазину- клієнт
має можливість зробити сформувати замовлення, яке складається тільки
з товарів, які є у магазині. При цьому він має можливість пошукати
товар за назвою та виробником, редагувати свої замовлення до моменту
їх формування та відгрузки. Якщо товару на складі не вистачає, клієнт
в момент додавання товару до замовлення  отримує відповідне повідомлення.
Продавець має можливість продивитись усі замовлення, сформувати їх з
товарів на складі та відправити замовникам. Модель повинна давати
можливість додавати товар на склад та формувати список товарів на
складі. Клієнт може продивитись всі свої замовлення та їх стан.
*/
    public static void main(String[] args) throws Exception {
        Product[]  listOfProducts =new Product[]{new Product("Watch 8.6","Meizu",3000,86),
                new Product("Iphone","Apple CO",12000,11),
                new Product("Smart TV","Samsung",33000,0),
                new Product("Watch 3.6","Huawei",5000,66)};

        AddTheProductToTheCatalog(listOfProducts);
        PrintTheCatalog();
        SortingByField(NAME);
        System.out.println();
        System.out.println();
        PrintTheCatalog();
        DeleteTheProductFromTheCatalog("Iphone");
        System.out.println();
        System.out.println();
        PrintTheCatalog();
        System.out.println();
        System.out.println();
        AddToTheBasketTheProduct("Smart TV");
        AddToTheBasketTheProduct("Watch 3.6");
        AddToTheBasketTheProduct("Watch 8.6");
        PrintMyBasket();
        System.out.println();
        System.out.println();
        DeleteTheProductFromTheBasket("Watch 8.6");
        PrintMyBasket();



    }
}
