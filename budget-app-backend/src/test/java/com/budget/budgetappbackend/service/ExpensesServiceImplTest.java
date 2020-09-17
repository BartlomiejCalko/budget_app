package com.budget.budgetappbackend.service;

import com.budget.budgetappbackend.repository.ExpenseRepository;
import com.budget.budgetappbackend.utils.CommonTools;
import com.budget.budgetappbackend.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ExpensesServiceImplTest {

    @InjectMocks
    private ExpensesServiceImpl expensesService;

    @Mock
    private ExpenseRepository expenseRepository;

    private TestUtils testUtils;

    @Mock
    private CommonTools tools;

    @BeforeEach
    void setUp() throws Exception {
        testUtils.generateGivenAmounOfTestExpenseObjects(1, 1, Timestamp.valueOf("2020-09-16 01:00:00.123456789"));
        
    }

    @Test
    void getExpenseBySearchCriteria() {
    }

    @Test
    void createExpense() {

        expensesService.createExpense(null);


    }

    @Test
    void getAllExpenses() {
    }

    @Test
    void deleteExpense() {
    }
}