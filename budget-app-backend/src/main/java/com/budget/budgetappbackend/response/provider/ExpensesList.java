package com.budget.budgetappbackend.response.provider;

import com.budget.budgetappbackend.model.Expense;

import java.util.List;

public class ExpensesList {

    private List<Expense> expenseList;

    public ExpensesList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public ExpensesList(){
        super();
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
