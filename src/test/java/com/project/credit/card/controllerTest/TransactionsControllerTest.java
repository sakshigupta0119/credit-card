package com.project.credit.card.controllerTest;
import com.project.credit.card.controller.transactionsController;
import com.project.credit.card.entities.Transactions;
import com.project.credit.card.service.TransactionsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class TransactionsControllerTest {

    @Mock
    private TransactionsServices transactionService;

    @InjectMocks
    private transactionsController transactionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTransactionByUserId() {
        String userId = "user123";
        List<Transactions> mockTransactions = new ArrayList<>();
        mockTransactions.add(new Transactions(1,"F","entertainment","Rajhans","Pune","Maharastra",12345,30.12));

        when(TransactionsServices.getTransactionsByUserId(userId)).thenReturn(mockTransactions);

        ResponseEntity<List<Transactions>> responseEntity = transactionController.getTransactionByUserId(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockTransactions, responseEntity.getBody());
    }

    @Test
    void testGetTransactionsByMerchant() {
        String merchant = "Rajhans";
        List<Transactions> mockTransactions = new ArrayList<>();
        mockTransactions.add(new Transactions(1,"F","entertainment","Rajhans","Pune","Maharastra",12345,30.12));

        when(transactionService.getTransactionsByMerchant(merchant)).thenReturn(mockTransactions);

        ResponseEntity<List<Transactions>> responseEntity = transactionController.getTransactionsByMerchant(merchant);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockTransactions, responseEntity.getBody());
    }

    @Test
    void testGetTransactionsByCategory() {
        String spendingCategory = "entertainment";
        List<Transactions> mockTransactions = new ArrayList<>();
        mockTransactions.add(new Transactions(1,"F","entertainment","Rajhans","Pune","Maharastra",12345,30.12));

        when(transactionService.getTransactionsBySpendingCategory(spendingCategory)).thenReturn(mockTransactions);

        ResponseEntity<List<Transactions>> responseEntity = transactionController.getTransactionsByCategory(spendingCategory);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockTransactions, responseEntity.getBody());
    }

    @Test
    void testCreateTransaction() {
        Transactions mockTransaction = new Transactions();
        when(transactionService.createTransaction(any(Transactions.class))).thenReturn(mockTransaction);

        ResponseEntity<Transactions> responseEntity = transactionController.createTransaction(mockTransaction);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockTransaction, responseEntity.getBody());
    }

}
