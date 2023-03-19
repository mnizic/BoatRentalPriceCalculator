package org.nizic.calculator;

public class PriceListItem {
    private int id;
    private String name;
    private int year;
    private int firstQuarterPrice;
    private int secondQuarterPrice;
    private int thirdQuarterPrice;
    private int fourthQuarterPrice;

    public PriceListItem(int id, String name, int year, int firstQuarterPrice, int secondQuarterPrice, int thirdQuarterPrice, int fourthQuarterPrice) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.firstQuarterPrice = firstQuarterPrice;
        this.secondQuarterPrice = secondQuarterPrice;
        this.thirdQuarterPrice = thirdQuarterPrice;
        this.fourthQuarterPrice = fourthQuarterPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFirstQuarterPrice() {
        return firstQuarterPrice;
    }

    public void setFirstQuarterPrice(int firstQuarterPrice) {
        this.firstQuarterPrice = firstQuarterPrice;
    }

    public int getSecondQuarterPrice() {
        return secondQuarterPrice;
    }

    public void setSecondQuarterPrice(int secondQuarterPrice) {
        this.secondQuarterPrice = secondQuarterPrice;
    }

    public int getThirdQuarterPrice() {
        return thirdQuarterPrice;
    }

    public void setThirdQuarterPrice(int thirdQuarterPrice) {
        this.thirdQuarterPrice = thirdQuarterPrice;
    }

    public int getFourthQuarterPrice() {
        return fourthQuarterPrice;
    }

    public void setFourthQuarterPrice(int fourthQuarterPrice) {
        this.fourthQuarterPrice = fourthQuarterPrice;
    }
}
