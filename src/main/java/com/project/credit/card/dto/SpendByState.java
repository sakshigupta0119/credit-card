package com.project.credit.card.dto;

public class SpendByState {

    private String state;
    private double totalAmount;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(double TotalAmount){
        this.totalAmount = TotalAmount;
    }
}
