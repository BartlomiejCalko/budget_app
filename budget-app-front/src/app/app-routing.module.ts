import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExpensesTableComponent } from './components/expenses-table/expenses-table/expenses-table.component';
import { NewExpenseComponent } from './components/new-expense/new-expense/new-expense.component';

const routes: Routes = [
  {
    path: '',
    component: NewExpenseComponent
  },
  {
    path: 'expenses-table',
    component: ExpensesTableComponent
  },
  {
    path: 'new-expense',
    component: NewExpenseComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
