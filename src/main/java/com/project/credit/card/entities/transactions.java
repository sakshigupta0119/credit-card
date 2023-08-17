package com.project.credit.card.entities;
// An entity to view the spending history of customer.

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document(collection = "transactions")
public class transactions {
    @Id
    private long trans_num;
    private String gender;  // gender
    private String category;  // spending category
    private String merchant;  // merchant
    private String city;  // city
    private String state;  // state
    private long city_population;  // population groups
    private Double amt;   // amount of spending (low value vs high value transactions)

//    public transactions(long trans_num, String gender, String category, String merchant, String city, String state, long city_population, Double amt) {
//        this.trans_num = trans_num;
//        this.gender = gender;
//        this.category = category;
//        this.merchant = merchant;
//        this.city = city;
//        this.state = state;
//        this.city_population = city_population;
//        this.amt = amt;
//    }
    public transactions(long trans_num){
        this.trans_num =trans_num;
    }


    public long getTrans_num() {
        return trans_num;
    }

    public void setTrans_num(long trans_num) {
        this.trans_num = trans_num;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getCity_population() {
        return city_population;
    }

    public void setCity_population(long city_population) {
        this.city_population = city_population;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        transactions that = (transactions) o;
        return trans_num == that.trans_num && city_population == that.city_population && amt == that.amt && Objects.equals(gender, that.gender) && Objects.equals(category, that.category) && Objects.equals(merchant, that.merchant) && Objects.equals(city, that.city) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trans_num, gender, category, merchant, city, state, city_population, amt);
    }
}
