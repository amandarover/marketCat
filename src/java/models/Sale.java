package models;

import java.util.ArrayList;
import java.util.Date;

public class Sale {

    private long idSale;
    private ArrayList<SaleItem> saleItem;
    private double totalSale;
    private Date saleDate;
    private String cpfCustomer;

    public long getIdSale() {
        return idSale;
    }

    public void setIdSale(long idSale) {
        this.idSale = idSale;
    }

    public ArrayList<SaleItem> getSaleItem() {
        return saleItem;
    }

    public void setSaleItem(ArrayList<SaleItem> saleItem) {
        this.saleItem = saleItem;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getCpfCustomer() {
        return cpfCustomer;
    }

    public void setCpfCustomer(String cpfCustomer) {
        this.cpfCustomer = cpfCustomer;
    }
}
