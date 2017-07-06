package models;

public class SaleItem {
    private long idSaleItem;
    private int quantity;
    private Product product;    

    public long getIdSaleItem() {
        return idSaleItem;
    }

    public void setIdSaleItem(long idSaleItem) {
        this.idSaleItem = idSaleItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
