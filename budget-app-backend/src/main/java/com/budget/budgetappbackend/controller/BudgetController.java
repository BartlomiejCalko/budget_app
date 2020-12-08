package com.budget.budgetappbackend.controller;

import com.budget.budgetappbackend.model.Expense;
import com.budget.budgetappbackend.response.provider.ExpenseResponseEntity;
import com.budget.budgetappbackend.response.provider.ExpenseResponseProvider;
import com.budget.budgetappbackend.response.provider.TagResponseEntity;
import com.budget.budgetappbackend.response.provider.TagResponseProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BudgetController {

    //Provider ExpensesService
    @Autowired
    private ExpenseResponseProvider expenseResponseProvider;

    //Provider TagService
    @Autowired
    private TagResponseProvider tagResponseProvider;

    @CrossOrigin
    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    public ExpenseResponseEntity saveExpense(@RequestBody Expense expense) {
        return expenseResponseProvider.saveExpense(expense);
    }

    @CrossOrigin
    @RequestMapping(value = "/expense/{expenseId}", method = RequestMethod.DELETE)
    public ExpenseResponseEntity deleteExpense(@PathVariable("expenseId") Long expenseId) {
        return expenseResponseProvider.deleteExpenses(expenseId);
    }

    @CrossOrigin
    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public ExpenseResponseEntity getAllExpenses() {
        return expenseResponseProvider.getAllExpenses();
    }

    @CrossOrigin
    @RequestMapping(value = "expense/criteria", method = RequestMethod.GET)
    public ExpenseResponseEntity getExpensesBySearchCriteria(@RequestParam(value = "tagNames") List<String> tagNames,
                                              @RequestParam(value = "fromDate") String fromDate,
                                              @RequestParam(value = "toDate") String toDate) {

        return expenseResponseProvider.getExpensesBySearchCriteria(tagNames, fromDate, toDate);
    }

    @CrossOrigin
    @RequestMapping(value = "tags", method = RequestMethod.GET)
    public TagResponseEntity getAlltags() {
        return tagResponseProvider.getAllTags();
    }

    @CrossOrigin
    @RequestMapping(value = "tag", method = RequestMethod.POST)
    public TagResponseEntity addNewTag(@RequestBody String name) {
        return tagResponseProvider.createTag(name);
    }

    @CrossOrigin
    @RequestMapping(value = "tag/{tagId}", method = RequestMethod.DELETE)
    public TagResponseEntity deleteTag(@PathVariable("tagId") Long tagId) {
        return tagResponseProvider.deleteTag(tagId);
    }












}
