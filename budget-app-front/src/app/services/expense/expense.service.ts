import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Expense } from 'src/app/models/Expense';
import { Tag } from 'src/app/models/Tag';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  constructor() { }

  public deleteExpense(expenseId: number) {
    //TODO - implement
    return of([]);
  }
  public saveExpense(expense: Expense) {
    //TODO - implement
    return of([]);
  }


  public getAllExpenses(): Observable<Expense[]> {
    let expense1 = {
      id:0,
      tags: [{name: "tag1"}],
      value: 20.20,
      date: "2020-11-15"
    }
    let expense2 = {
      id:1,
      tags: [{name: "tag2"}],
      value: 50.50,
      date: "2020-11-13"
    }

    return of([expense1, expense2]);
  }


  public getExpenseFromData(tags: Tag[], value: number) {
    let expenseDate = new Date().toISOString();
    let expense: Expense = {
      id: 0,
      tags: tags,
      value: value,
      date: expenseDate
    }
    return expense;
  }

  public addExpense(expense: Expense) {
    
    return of(expense);
  }

}
