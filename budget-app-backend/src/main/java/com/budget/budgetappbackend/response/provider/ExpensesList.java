package com.budget.budgetappbackend.response.provider;

import com.budget.budgetappbackend.model.Expense;

import java.util.List;

public class ExpensesList {

    private List<Expense> expenses;

    public ExpensesList(List<Expense> expenseList) {
        this.expenses = expenseList;
    }

    public ExpensesList(){
        super();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenses = expenseList;
    }
}
