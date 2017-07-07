package models;

import java.util.Date;

public class Product {
    private long idProduct;
    private String imageUrl;
    private String name;
    private String description;
    private String unitOfMeasure;
    private double pricePerUnit;
    private double minimunStock;
    private Date validateDate;
    private double stock;
    private boolean closeout;
    private Date expirationDateCloseout;
    private double minimunCloseout;
    private double percentageCloseout;

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getMinimunStock() {
        return minimunStock;
    }

    public void setMinimunStock(double minimunStock) {
        this.minimunStock = minimunStock;
    }

    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public boolean isCloseout() {
        return closeout;
    }

    public void setCloseout(boolean closeout) {
        this.closeout = closeout;
    }

    public Date getExpirationDateCloseout() {
        return expirationDateCloseout;
    }

    public void setExpirationDateCloseout(Date expirationDateCloseout) {
        this.expirationDateCloseout = expirationDateCloseout;
    }

    public double getMinimunCloseout() {
        return minimunCloseout;
    }

    public void setMinimunCloseout(double minimunCloseout) {
        this.minimunCloseout = minimunCloseout;
    }

    public double getPercentageCloseout() {
        return percentageCloseout;
    }

    public void setPercentageCloseout(double percentageCloseout) {
        this.percentageCloseout = percentageCloseout;
    } 
}
