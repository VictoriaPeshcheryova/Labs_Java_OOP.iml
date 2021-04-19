package Lab5.entities;

public class Product {
    int id;
    String nameOfTheProduct;
    String companyNameOfAProduct;
    int priceOfAProduct;
    boolean isAvailable;

    public Product(String nameOfTheProduct, String companyNameOfAProduct, int priceOfAProduct, boolean isAvailable) {
        this.nameOfTheProduct = nameOfTheProduct;
        this.companyNameOfAProduct = companyNameOfAProduct;
        this.priceOfAProduct = priceOfAProduct;
        this.isAvailable = isAvailable;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
