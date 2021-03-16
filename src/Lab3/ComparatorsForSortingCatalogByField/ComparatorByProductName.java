package Lab3.ComparatorsForSortingCatalogByField;

import Lab3.Product;

import java.util.Comparator;

public class ComparatorByProductName implements Comparator<Product>  {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getNameOfTheProduct().compareTo(o2.getNameOfTheProduct());
    }
}
