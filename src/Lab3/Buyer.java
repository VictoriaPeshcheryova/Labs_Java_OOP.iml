package Lab3;

import Lab3.ActionsWithCatalog.SortingTheCatalogByField;
import Lab3.ComparatorsForSortingCatalogByField.ComparatorByProductCompanyName;
import Lab3.ComparatorsForSortingCatalogByField.ComparatorByProductName;
import Lab3.ComparatorsForSortingCatalogByField.ComparatorByProductPrice;
import Lab3.EnumsForSortingCatalogByField.SortingCatalogByField;

import java.util.*;

public class Buyer extends User implements SortingTheCatalogByField{
    protected ArrayList<Product> basket;

    public Buyer(String login, String password) {
        super(login, password);
        basket = new ArrayList<>();
    }

    public void addTheProductToTheBasket(String productsName) {

    }

    public boolean deleteTheProductFromTheBasket(String nameOfProduct) {
        return basket .removeIf(product -> product.getNameOfTheProduct().equals(nameOfProduct));
    }

    @Override
    public void SortingByField(SortingCatalogByField option) {
        switch (option) {
            case NAME: {
                Collections.sort(basket, new ComparatorByProductName());
            }
            break;
            case PRICE: {
                Collections.sort(basket, new ComparatorByProductPrice());
            }
            break;
            case COMPANY_NAME: {
                Collections.sort(basket, new ComparatorByProductCompanyName());
            }
            break;

        }
    }


    public void printMyBasket(){
        System.out.println(basket.toString());
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "basket=" + basket +
                '}';
    }
}
