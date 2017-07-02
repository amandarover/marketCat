package models;

import java.util.ArrayList;

public class Product {
    private long idProduct;
    private String image;
    private String name;
    private String description;
    private String unitOfMeasure;
    private double pricePerUnit;
    private double minimunStock;
    private ArrayList<ProductStock> productStock; 
}
