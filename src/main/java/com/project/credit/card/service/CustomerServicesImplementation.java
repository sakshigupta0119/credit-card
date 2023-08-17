package com.project.credit.card.service;

import com.project.credit.card.Entities.customers;

import java.util.List;

public interface CustomerServicesImplementation {
    public List<customers> getCustomerByGender(String _gender);
    public List<customers> getCustomerByProfession(String _profession);
}
