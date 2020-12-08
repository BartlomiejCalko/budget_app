import { ObserversModule } from '@angular/cdk/observers';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, Subject } from 'rxjs';
import { Expense } from 'src/app/models/Expense';
import { Tag } from 'src/app/models/Tag';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  public retreivedExpenseResult: Observable<Expense[]>;
  public deleteExpenseResult: Observable<Expense[]>;
  public addedExpensesResult: Observable<Expense[]>;
  public hostAdress: String = "http://localhost:8081/";
  public subject = new Subject<HttpErrorResponse>();



  constructor(private httpClient: HttpClient) { }

  onErrorOccurrs(): Observable<HttpErrorResponse> {
    return this.subject.asObservable();
  }

  public deleteExpense(expenseId: number) {
    this.deleteExpenseResult = new Observable(observer => {
      let url = this.hostAdress + 'expense/' + expenseId;
      this.httpClient.delete<any>(url).subscribe(response => {
        observer.next(response);
      }, err => this.handlerException(err));
    });
    return this.deleteExpenseResult;
  }
  public saveExpense(expense: Expense) {

    this.addedExpensesResult = new Observable(observer => {

      let url = this.hostAdress + "expense";
      let httpOptions = {
        headers: new HttpHeaders({
          'Content-Type' : 'application/json'
        })
      };

      let tagNames: string[] = [];
      if (typeof(expense.tags)=="string") {
        let tags: String = expense.tags;
        let tagsArr = tags.split(',');
        expense.tags = [];
        tagsArr.forEach(val => expense.tags.push({name: val}));
      }
      expense.tags.forEach(val => tagNames.push(String(val.name)));
      let objectToSend = null;
      if (expense.id) {
        objectToSend = {
          "id" : expense.id,
          "value" : expense.value,
          "tags" : expense.tags,
          "formatedDate" : expense.date}
        } else {
          objectToSend = {
            "value" : expense.value,
            "tags" : expense.tags
          }
        }

        this.httpClient.post<any>(url, objectToSend, httpOptions).subscribe(response => {
          observer.next(response);
        }, err => this.handlerException(err));
        

    });

    return this.addedExpensesResult;
    
  }

  public handlerException(err: HttpErrorResponse) {
    this.subject.next(err);
  }

  public getAllExpenses(): Observable<Expense[]> {
    this.retreivedExpenseResult = new Observable(observer => {
      let url = this.hostAdress + "expenses";
      this.httpClient.get(url).subscribe(response => {
        let expenses = response['expenses'];
        observer.next(expenses);
      }, err => this.handlerException(err));
    });
    return this.retreivedExpenseResult;
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
    
    return this.saveExpense(expense);
  }

}
