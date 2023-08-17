package com.project.credit.card.dto;

public class SpendByMerchant {
    private String merchant;

    private double totalAmount;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(double TotalAmount){
        this.totalAmount = TotalAmount;
    }
}
