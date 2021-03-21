package Lab3;

import java.util.ArrayList;
import java.util.Collections;

public class Shop {

    protected static  ArrayList<Product> catalog =new ArrayList<>();

    public boolean addTheProductToTheCatalog( Product... products) {
        return Collections.addAll(this.catalog , products);
    }

    public boolean deleteTheProductFromTheCatalog(String name) {
        return catalog .removeIf(product -> product.getNameOfTheProduct().equals(name));
    }


    public String printTheCatalog()
    {
       return catalog.toString();
    }


    @Override
    public String toString() {
        return "Shop{" +
                "catalog=" + catalog  +
                '}';
    }
}
