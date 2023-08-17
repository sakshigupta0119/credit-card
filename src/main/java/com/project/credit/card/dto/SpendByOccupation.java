package com.project.credit.card.dto;

public class SpendByOccupation {

    private String job;
    private double totalAmount;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(double TotalAmount){
        this.totalAmount = TotalAmount;
    }
}
