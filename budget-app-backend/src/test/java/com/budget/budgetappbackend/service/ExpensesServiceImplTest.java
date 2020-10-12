package com.budget.budgetappbackend.service;

import com.budget.budgetappbackend.model.Expense;
import com.budget.budgetappbackend.model.ExpensesSearchCriteria;
import com.budget.budgetappbackend.model.Tag;
import com.budget.budgetappbackend.repository.ExpenseRepository;
import com.budget.budgetappbackend.utils.CommonTools;
import com.budget.budgetappbackend.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ExpensesServiceImplTest {

    @InjectMocks
    private ExpensesServiceImpl expensesService;

    @Mock
    private ExpenseRepository expenseRepository;

    private TestUtils testUtils;

    @Mock
    private CommonTools tools;

    Timestamp fromDate;
    Timestamp toDate;

    private List<Expense> generatedExpenses;

    private Expense testExpense;

    @BeforeEach
    void setUp() throws Exception {
        testUtils = new TestUtils();
        generatedExpenses = testUtils.generateGivenAmounOfTestExpenseObjects(1,1, Timestamp.valueOf("2020-09-29 01:00:00.123456789"));
        fromDate = Timestamp.valueOf("2020-09-29 01:02:03.123456789");
        toDate = Timestamp.valueOf("2020-10-05 01:02:03.123456789");
        testExpense = testUtils.generateGivenAmounOfTestExpenseObjects(1,1, Timestamp.valueOf("2020-09-30 01:00:00.123456789")).get(0);

        Mockito.when(expenseRepository.save(Mockito.any(Expense.class))).thenReturn(testExpense);
        Mockito.when(expenseRepository.findAll()).thenReturn(generatedExpenses);
    }

    @Test
    void testGetExpenesesByCriteriaWithTagsSettedOnly() {
        ExpensesSearchCriteria expensesSearchCriteria = new ExpensesSearchCriteria();
        List<String> tagNames = generatedExpenses.get(0).getTags().stream().map(Tag::getName).collect(Collectors.toList());
        expensesSearchCriteria.setTagNames(tagNames);
        Optional<List<Expense>> foundExpenses = expensesService.getExpenseBySearchCriteria(expensesSearchCriteria);
        assertTrue(foundExpenses.get().size() > 0);
    }

    @Test
    void testGetExpensesByCriteriaWithFromDateSettedOnly() {
        ExpensesSearchCriteria expensesSearchCriteria = new ExpensesSearchCriteria();
        expensesSearchCriteria.setFromDate(fromDate);
        Optional<List<Expense>> foundExpenses = expensesService.getExpenseBySearchCriteria(expensesSearchCriteria);
        assertTrue(foundExpenses.get().size() > 0);
    }

    @Test
    void testGetExpensesByCriteriaWithToDateSettedOnly() {
        ExpensesSearchCriteria expensesSearchCriteria = new ExpensesSearchCriteria();
        expensesSearchCriteria.setToDate(toDate);
        Optional<List<Expense>> foundExpenses = expensesService.getExpenseBySearchCriteria(expensesSearchCriteria);
        assertTrue(foundExpenses.get().size() > 0);
    }

    @Test
    void testGetExpensesByCriteriaWithBothDateSettedOnly() {
        ExpensesSearchCriteria expensesSearchCriteria = new ExpensesSearchCriteria();
        expensesSearchCriteria.setFromDate(fromDate);
        expensesSearchCriteria.setToDate(toDate);
        Optional<List<Expense>> foundExpenses = expensesService.getExpenseBySearchCriteria(expensesSearchCriteria);
        assertTrue(foundExpenses.get().size() > 0);
    }

    @Test
    void testGetExpensesByCriteriaWithBothDateAndTagsSetted() {
        ExpensesSearchCriteria expensesSearchCriteria = new ExpensesSearchCriteria();
        expensesSearchCriteria.setFromDate(fromDate);
        expensesSearchCriteria.setToDate(toDate);
        List<String> tagNames = generatedExpenses.get(0).getTags().stream().map(Tag::getName).collect(Collectors.toList());
        expensesSearchCriteria.setTagNames(tagNames);
        Optional<List<Expense>> foundExpenses = expensesService.getExpenseBySearchCriteria(expensesSearchCriteria);
        assertTrue(foundExpenses.get().size() > 0);
    }

    @Test
    void createExpense() {
        Expense createdExpense;
        createdExpense = expensesService.createExpense(testExpense);
        assertNotNull(createdExpense);
        assertEquals(createdExpense.getValue(), testExpense.getValue());
    }

    @Test
    void getAllExpenses() {
        Optional<List<Expense>> allExpenses = expensesService.getAllExpenses();
        assertEquals(allExpenses.get().size(), generatedExpenses.size());
    }

    @Test
    void deleteExpense() {
        Expense expense = expenseRepository.findAll().get(0);
        expensesService.deleteExpense(expense.getId());
        Optional<Expense> foundByIdAfterDelete = expenseRepository.findById(expense.getId());
        assertFalse(foundByIdAfterDelete.isPresent());
    }
}