package VO;

public class Product {
    private String barcode;
    private String productName;
    private double price;
    private String supply;

    public String getBarcode() {return barcode;}
    public void setBarcode(String barcode) {this.barcode = barcode;}
    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public String getSupply() {return supply;}
    public void setSupply(String supply) {this.supply = supply;}

    public Product(String barcode, String productName, double price, String supply) {
        this.barcode = barcode;
        this.productName = productName;
        this.price = price;
        this.supply = supply;
    }

    public Product() {}
}
