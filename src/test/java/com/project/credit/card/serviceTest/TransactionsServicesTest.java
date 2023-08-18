package com.project.credit.card.serviceTest;

import com.project.credit.card.dao.TransactionsMongoDB;
import com.project.credit.card.dto.*;
import com.project.credit.card.entities.Transactions;
import com.project.credit.card.repositories.TransactionsRepository;
import com.project.credit.card.service.TransactionsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
public class TransactionsServicesTest {

    @Mock
    private TransactionsRepository transactionsRepository;

    @Mock
    private TransactionsMongoDB transactionsMongoDB;

    private TransactionsServices transactionsServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionsServices = new TransactionsServices(transactionsRepository);
    }

    @Test
    public void testGetGenderWiseSpending() {
        List<SpendByGender> expected = new ArrayList<>();

        when(transactionsMongoDB.getSpendHistoryByGender()).thenReturn(expected);

        List<SpendByGender> result = transactionsServices.getGenderWiseSpending();

        assertEquals(expected, result);
    }

    @Test
    public void testGetCategoryWiseSpending() {
        List<SpendByCategory> expected = new ArrayList<>();

        when(transactionsMongoDB.getSpendingHistoryByCategory()).thenReturn(expected);

        List<SpendByCategory> result = transactionsServices.getCategoryWiseSpending();

        assertEquals(expected, result);
    }

    @Test
    public void testGetCityWiseSpending() {
        List<SpendByCity> expected = new ArrayList<>();

        when(transactionsMongoDB.getSpendingHistoryByCity()).thenReturn(expected);

        List<SpendByCity> result = transactionsServices.getCityWiseSpending();

        assertEquals(expected, result);
    }

    @Test
    public void testGetStateWiseSpending() {
        List<SpendByState> expected = new ArrayList<>();

        when(transactionsMongoDB.getSpendingHistoryByState()).thenReturn(expected);

        List<SpendByState> result = transactionsServices.getStateWiseSpending();

        assertEquals(expected, result);
    }

    @Test
    public void testGetMerchantWiseSpending() {
        List<SpendByMerchant> expected = new ArrayList<>();

        when(transactionsMongoDB.getSpendingHistoryByMerchant()).thenReturn(expected);

        List<SpendByMerchant> result = transactionsServices.getMerchantWiseSpending();

        assertEquals(expected, result);
    }

    @Test
    public void testGetJobWiseSpending() {
        List<SpendByOccupation> expected = new ArrayList<>();

        when(transactionsMongoDB.getSpendingHistoryByProfession()).thenReturn(expected);

        List<SpendByOccupation> result = transactionsServices.getJobWiseSpending();

        assertEquals(expected, result);
    }

    @Test
    public void testGetLowValueTransactions() {
        List<Transactions> expected = new ArrayList<>();

        when(transactionsMongoDB.getLowValueTransactions()).thenReturn(expected);

        List<Transactions> result = transactionsServices.getLowValueTransactions();

        assertEquals(expected, result);
    }

    @Test
    public void testGetHighValueTransactions() {
        List<Transactions> expected = new ArrayList<>();

        when(transactionsMongoDB.getHighValueTransactions()).thenReturn(expected);

        List<Transactions> result = transactionsServices.getHighValueTransactions();

        assertEquals(expected, result);
    }

    @Test
    public void testGetTransactionsByUserId() {
        String userId = "user123";
        List<Transactions> expected = new ArrayList<>();

        when(transactionsRepository.findByUserId(userId)).thenReturn(expected);

        List<Transactions> result = TransactionsServices.getTransactionsByUserId(userId);

        assertEquals(expected, result);
    }

    @Test
    public void testGetTransactionsByMerchant() {
        String merchant = "MerchantABC";
        List<Transactions> expected = new ArrayList<>();

        when(transactionsRepository.findByMerchant(merchant)).thenReturn(expected);

        List<Transactions> result = transactionsServices.getTransactionsByMerchant(merchant);

        assertEquals(expected, result);
    }

    @Test
    public void testGetTransactionsBySpendingCategory() {
        String spendingCategory = "CategoryXYZ";
        List<Transactions> expected = new ArrayList<>();

        when(transactionsRepository.findBySpendingCategory(spendingCategory)).thenReturn(expected);

        List<Transactions> result = transactionsServices.getTransactionsBySpendingCategory(spendingCategory);

        assertEquals(expected, result);
    }

    @Test
    public void testCreateTransaction() {
        Transactions inputTransaction = new Transactions();

        when(transactionsRepository.save(inputTransaction)).thenReturn(inputTransaction);

        Transactions resultTransaction = transactionsServices.createTransaction(inputTransaction);

        assertEquals(inputTransaction, resultTransaction);
    }


}