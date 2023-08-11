package com.project.credit.card.Entities;
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
    private long amt;   // amount of spending (low value vs high value transactions)

    public transactions(String gender, String category, String merchant, String city, String state, long city_population, long amt) {
        this.gender = gender;
        this.category = category;
        this.merchant = merchant;
        this.city = city;
        this.state = state;
        this.city_population = city_population;
        this.amt = amt;
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

    public long getAmt() {
        return amt;
    }

    public void setAmt(long amt) {
        this.amt = amt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        transactions that = (transactions) o;
        return city_population == that.city_population && amt == that.amt && Objects.equals(gender, that.gender) && Objects.equals(category, that.category) && Objects.equals(merchant, that.merchant) && Objects.equals(city, that.city) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, category, merchant, city, state, city_population, amt);
    }
}
