package com.project.credit.card.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class customers {

    @Id
    private long customerId;
    private String id;
    private String first;
    private String last;
    private String gender;
    private String job;
    private Date dob;

    public customers() {
    }
    @Field("job")
    private String occupation;
    public long getCustomerId() {
        return customerId;
    }

    public String getJob() {
        return job;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setJob(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}