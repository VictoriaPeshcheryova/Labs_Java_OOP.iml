package Lab3;

import java.util.Comparator;
import java.util.HashMap;

public class Product {
    protected String nameOfTheProduct;
    protected String companyNameOfAProduct;
    protected int priceOfAProduct;
    protected int amountOfProductInStock;

    public Product(String nameOfTheProduct, String companyNameOfAProduct, int priceOfAProduct, int amountOfProductInStock) {
        this.nameOfTheProduct = nameOfTheProduct;
        this.companyNameOfAProduct = companyNameOfAProduct;
        this.priceOfAProduct = priceOfAProduct;
        this.amountOfProductInStock = amountOfProductInStock;
    }
    public Product(){

    }

    public String getNameOfTheProduct() {
        return nameOfTheProduct;
    }

    public void setNameOfTheProduct(String nameOfTheProduct) {
        this.nameOfTheProduct = nameOfTheProduct;
    }

    public String getCompanyNameOfAProduct() {
        return companyNameOfAProduct;
    }

    public void setCompanyNameOfAProduct(String companyNameOfAProduct) {
        this.companyNameOfAProduct = companyNameOfAProduct;
    }

    public int getPriceOfAProduct() {
        return priceOfAProduct;
    }

    public void setPriceOfAProduct(int priceOfAProduct) {
        this.priceOfAProduct = priceOfAProduct;
    }

    public int getAmountOfProductInStock() {
        return amountOfProductInStock;
    }

    public void setAmountOfProductInStock(int amountOfProductInStock) {
        this.amountOfProductInStock = amountOfProductInStock;
    }


    @Override
    public String toString() {
        return "Product{" +
                "nameOfTheProduct='" + nameOfTheProduct + '\'' +
                ", companyNameOfAProduct='" + companyNameOfAProduct + '\'' +
                ", priceOfAProduct=" + priceOfAProduct +
                ", amountOfProductInStock=" + amountOfProductInStock +
                '}';
    }

}
