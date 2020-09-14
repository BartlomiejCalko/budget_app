package com.budget.budgetappbackend.repository;

import com.budget.budgetappbackend.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository {

    Optional<Expense> findById(Long id);

    Expense save(Expense expense);

    List<Expense> findAll();

    void deleteById(Long expenseId);


}
