/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sirac
 */
public class cellphone {
    private String cellName,manufacturer;
    private int price,cellCode;

    public cellphone() {
    }

    public cellphone( int cellCode,String cellName, int price, String manufacturer) {
        this.cellName = cellName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.cellCode = cellCode;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCellCode() {
        return cellCode;
    }

    public void setCellCode(int cellCode) {
        this.cellCode = cellCode;
    }
    
}
