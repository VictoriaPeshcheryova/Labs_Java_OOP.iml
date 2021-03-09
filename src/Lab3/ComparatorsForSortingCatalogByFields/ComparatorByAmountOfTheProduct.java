package Lab3.ComparatorsForSortingCatalogByFields;

import Lab3.Product;

import java.util.Comparator;

public class ComparatorByAmountOfTheProduct  implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getAmountOfProductInStock()-o2.getAmountOfProductInStock();
    }
}
