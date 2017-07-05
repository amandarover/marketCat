
package models;

import java.util.ArrayList;

public class Sale {
    private ArrayList<SaleItem> saleItem;
    private double totalSale;

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
    
    
    
}
