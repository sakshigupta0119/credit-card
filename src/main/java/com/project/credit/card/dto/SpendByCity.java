package com.project.credit.card.dto;

public class SpendByCity {
    private String city;
    private double totalAmount;
    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(double TotalAmount){
        this.totalAmount = TotalAmount;
    }
}
