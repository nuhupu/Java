/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nhozk
 */
public class Cellphone {

    private int cellCode;
    private String cellName;
    private int price;
    private String manufacturer;

    public Cellphone() {
    }

    public Cellphone(int cellCode, String cellName, int price, String manufacturer) {
        this.cellCode = cellCode;
        this.cellName = cellName;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public int getCellCode() {
        return cellCode;
    }

    public void setCellCode(int cellCode) {
        this.cellCode = cellCode;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    
}
