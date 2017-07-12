package com.Tas;

/**
 * Created by TasdiqueC on 7/12/17.
 */
public class Invoice {
    private int PartNumber, Quantity;
    private String PartDesc;
    private double Price, Value;

    public Invoice(int PartNumber, String PartDesc, int Quantity, double Price) {
        this.PartNumber = PartNumber;
        this.PartDesc = PartDesc;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Value = Quantity * Price;
    }

    public int getPartNumber() {return PartNumber;}
    public int getQuantity() {return Quantity;}
    public String getPartDesc() {return PartDesc;}
    public double getPrice () {return Price;}
    public double getValue () {return Value;}

    public String getPartDescAndQuantity() {return PartDesc + ", " + Quantity;}
    public String getPartDescAndValue() {return PartDesc + ", " + Value;}

    @Override
    public String toString() {
        return String.format("Part Number: %d, Part Description: %s, Quantity: %d, Price: %f.",PartNumber, PartDesc, Quantity, Price);
    }
}