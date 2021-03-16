package Lab3.ComparatorsForSortingCatalogByField;

import Lab3.Product;

import java.util.Comparator;

public class ComparatorByProductPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPriceOfAProduct()-o2.getPriceOfAProduct();
    }
}
