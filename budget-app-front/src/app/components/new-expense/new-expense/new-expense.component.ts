import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatAutocomplete } from '@angular/material/autocomplete';
import { Tag } from 'src/app/models/Tag';

@Component({
  selector: 'app-new-expense',
  templateUrl: './new-expense.component.html',
  styleUrls: ['./new-expense.component.css']
})
export class NewExpenseComponent {

  @ViewChild('tagsInput', {static:true}) tagsInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto', {static:true}) auto: MatAutocomplete;

  public readonly separatorKeyCodes: number[] = [13,188];
  public addOnBlur = true;
  public selectedTags: Tag[] = [];

  public expenseForm = new FormGroup({
    tags: new FormControl(undefined),
    value: new FormControl(undefined, Validators.required)
  });

  get tagsControl(): FormControl {
    return this.expenseForm.get('tags') as FormControl
  }

  get valueControl(): FormControl{
    return this.expenseForm.get('value') as FormControl
  }



  constructor() { }

  public add(event: any) {}

  public addExpenseClickHandler() {
    console.log('addExpenseClickHandler invoked');
  }

  public selected(event: any) {
    console.log('selected method invoked');
  }

  public submitExpense(event: any) {
    console.log('submitExpense invoked');
  }


}
