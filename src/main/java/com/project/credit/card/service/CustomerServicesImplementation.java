package com.project.credit.card.service;

import com.project.credit.card.entities.Customers;

import java.util.List;

public interface CustomerServicesImplementation {
    public List<Customers> getCustomerByGender(String gender);
    public List<Customers> getCustomerByOccupation(String occupation);
}
