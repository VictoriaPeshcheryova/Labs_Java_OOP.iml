package Lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Basket extends Catalog {
    protected static ArrayList<Product> basket=new ArrayList<>();

    public static void AddToTheBasketTheProduct(String nameOfProduct)
    {
        try {
            ProductCheck(nameOfProduct);
        }

        catch (Exception ex)
        {
            System.out.println("Product is not available!");
        }

    }

    public static void ProductCheck(String nameOfProduct)
    {
        Product product = catalog.stream()
                .filter(x -> x.nameOfTheProduct == nameOfProduct&&x.amountOfProductInStock!=0)
                .findFirst()
                .get();
        basket.add(product);
    }
    public static void DeleteTheProductFromTheBasket(String nameOfTheProduct)
    {
        basket.removeIf(product -> product.getNameOfTheProduct().equals(nameOfTheProduct));
    }

    public static void PrintMyBasket(){

        System.out.println(basket);

    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }
}
