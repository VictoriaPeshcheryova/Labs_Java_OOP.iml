package Lab3;

public class Product {
    protected String nameOfTheProduct;
    protected String companyNameOfAProduct;
    protected int priceOfAProduct;
    protected boolean isAvailable;

    public String getNameOfTheProduct() {
        return nameOfTheProduct;
    }
    public String getCompanyNameOfAProduct() {
        return companyNameOfAProduct;
    }
    public int    getPriceOfAProduct() {
        return priceOfAProduct;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setNameOfTheProduct(String nameOfTheProduct) {
        this.nameOfTheProduct = nameOfTheProduct;
    }
    public void setCompanyNameOfAProduct(String companyNameOfAProduct) { this.companyNameOfAProduct = companyNameOfAProduct; }
    public void setPriceOfAProduct(int priceOfAProduct) {
        this.priceOfAProduct = priceOfAProduct;
    }
    public void setAmountOfProductInStock(boolean isAvaliable) { this.isAvailable = isAvaliable; }


    public Product(String nameOfTheProduct, String companyNameOfAProduct, int priceOfAProduct, boolean isAvaliable) {
        this.nameOfTheProduct = nameOfTheProduct;
        this.companyNameOfAProduct = companyNameOfAProduct;
        this.priceOfAProduct = priceOfAProduct;
        this.isAvailable = isAvaliable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameOfTheProduct='" + nameOfTheProduct + '\'' +
                ", companyNameOfAProduct='" + companyNameOfAProduct + '\'' +
                ", priceOfAProduct=" + priceOfAProduct +
                ", amountOfProductInStock=" + isAvailable +
                '}';
    }

}
