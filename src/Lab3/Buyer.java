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
        for (Product item : Shop.catalog) {
            if(item.nameOfTheProduct.equals(productsName)){
                if(!item.isAvailable){
                    System.out.println("No such product available");
                    return;
                }
                basket.add(item);
                item.isAvailable = false;
                return;
            }
        }
        System.out.println("No such product available");
    }

    public boolean deleteTheProductFromTheBasket(String nameOfProduct) {
        return basket .removeIf(product -> product.getNameOfTheProduct().equals(nameOfProduct));
    }

    public boolean searchItemInMyBasketName(String nameOfProduct){
        for(Product product: basket)
        {
            if(product.nameOfTheProduct.equals(nameOfProduct))
            {
                System.out.println(product.toString());
                return true;
            }
        }
        return false;
    }
    public boolean searchItemInMyBasketCompanyName(String companyName){
        for(Product product: basket)
        {
            if(product.companyNameOfAProduct.equals(companyName))
            {
                System.out.println(product);
                return true;
            }
        }
        return false;
    }
    public boolean searchItemInMyBasketPrice(int priceOfProduct){
        for(Product product: basket)
        {
            if(product.priceOfAProduct==priceOfProduct)
            {
                System.out.println(product);
                return true;
            }
        }
        return false;
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


    public String printMyBasket(){
        return basket.toString();
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "basket=" + basket +
                '}';
    }
}
