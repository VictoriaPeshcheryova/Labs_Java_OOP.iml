package Lab3;

import java.util.ArrayList;

public class Catalog extends Product{

    protected static ArrayList<Product> catalog=new ArrayList<>();

    public static void AddTheProductToTheCatalog( Product...products)
    {
        for(Product product: products){
            catalog.add(product);
        }
    }

    public static void DeleteTheProductFromTheCatalog(String name)
    {
        catalog.removeIf(product -> product.getNameOfTheProduct().equals(name));
    }

    public static void PrintTheCatalog()
    {
        System.out.println(catalog);
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalog=" + catalog +
                '}';
    }
}
