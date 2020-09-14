package com.budget.budgetappbackend.service;

import com.budget.budgetappbackend.model.Expense;
import com.budget.budgetappbackend.model.ExpensesSearchCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ExpensesService {

    public Optional<List<Expense>> getExpenseBySearchCriteria(ExpensesSearchCriteria criteria);

    public Expense createExpense(Expense expense);

    Optional<List<Expense>> getAllExpenses();

    public void deleteExpense(Long expenseId);

}
