package com.project.credit.card.dto;

public class SpendByGender {
    private String gender;
    private double totalAmount;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(double TotalAmount){
        this.totalAmount = TotalAmount;
    }
}
