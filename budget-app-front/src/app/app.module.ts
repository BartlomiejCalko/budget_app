import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import { NewExpenseComponent } from './components/new-expense/new-expense/new-expense.component';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';
import { MAT_CHIPS_DEFAULT_OPTIONS, MatChipsModule } from '@angular/material/chips';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { HttpClientModule } from '@angular/common/http';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { AddedExpenseModalComponent } from './components/new-expense/added-expense-modal/added-expense-modal/added-expense-modal.component';
import { ExpensesTableComponent } from './components/expenses-table/expenses-table/expenses-table.component';
import { EditExpeneseModalComponent } from './components/expenses-table/edit-expense-modal/edit-expenese-modal/edit-expenese-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    NewExpenseComponent,
    AddedExpenseModalComponent,
    ExpensesTableComponent,
    EditExpeneseModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    NoopAnimationsModule,
    MatCardModule,
    MatChipsModule,
    MatAutocompleteModule,
    NoopAnimationsModule,
    MatButtonModule,
    HttpClientModule,
    MatInputModule,
    MatTableModule,
    MatIconModule,
    MatSnackBarModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule

  ],
  providers: [{provide: MAT_CHIPS_DEFAULT_OPTIONS, useValue:{ separatorKeyCodes: [13, 188]}}],
  bootstrap: [AppComponent]
})
export class AppModule { }
