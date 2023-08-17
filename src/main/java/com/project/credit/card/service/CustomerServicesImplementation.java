package com.project.credit.card.service;

import com.project.credit.card.entities.customers;

import java.util.List;

public interface CustomerServicesImplementation {
    public List<customers> getCustomerByGender(String gender);
    public List<customers> getCustomerByOccupation(String occupation);
}
