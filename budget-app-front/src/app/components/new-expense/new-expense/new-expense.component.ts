import { map, filter, tap } from 'rxjs/operators'
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatAutocomplete, MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';
import { Tag } from 'src/app/models/Tag';
import { TagService } from 'src/app/sevices/tag/tag.service';
import { Observable, Subscription } from 'rxjs';
import { MatChipInputEvent } from '@angular/material/chips';
import { ExpenseService } from 'src/app/services/expense/expense.service';
import { MatDialog } from '@angular/material/dialog';
import { AddedExpenseModalComponent } from '../added-expense-modal/added-expense-modal/added-expense-modal.component';

@Component({
  selector: 'app-new-expense',
  templateUrl: './new-expense.component.html',
  styleUrls: ['./new-expense.component.css']
})
export class NewExpenseComponent implements OnInit{

  @ViewChild('tagsInput', {static:true}) tagsInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto', {static:true}) auto: MatAutocomplete;

  public readonly separatorKeyCodes: number[] = [13,188];
  public addOnBlur = true;
  public selectedTags: Tag[] = [];
  public allTags: Tag[] = [];
  public filteredTags: Observable<Tag[]>;
  public removableChip: boolean = true;
  public errorSubscription: Subscription;

  public expenseForm = new FormGroup({
    tags: new FormControl(undefined),
    value: new FormControl(undefined, [Validators.required, Validators.pattern('^(?:0|[1-9][0-9]*)\.[0-9]+$')])
  });

  get tagsControl(): FormControl {
    return this.expenseForm.get('tags') as FormControl
  }

  get valueControl(): FormControl{
    return this.expenseForm.get('value') as FormControl
  }

  constructor(private tagService: TagService, private expenseService: ExpenseService, public dialog: MatDialog) { }

  ngOnInit(): void {

    this.errorSubscription = this.tagService.onErrorOccurrs().subscribe( error => {
      
    });

    this.tagService.getAllTags().subscribe(response=> {
      this.allTags = response;
    });    
    this.filteredTags = this.tagsControl.valueChanges.pipe(
      map((val: any | null) => val ? this.filterTags(val) : this.allTags.slice())
    );
  }

  private filterTags(tag: any):Tag[] {
    let filterValue = '';
    if(typeof(tag)=="object") {
      filterValue = tag.name.toLowerCase();
    }else {
      filterValue = tag.toLowerCase();
    }
    return this.allTags.filter(val => val.name.toLowerCase().includes(filterValue));
  }

  public remove(tagToRemove: Tag) {
    this.selectedTags = this.selectedTags.filter(tag=> tag.name != tagToRemove.name)
  }


  public add(event: MatChipInputEvent) {
    let input = event.input.value;
    if(input != '') {
      input = input.trim();
      let inputArr = input.split(" ");
      for(let currentInp of inputArr) {
        if(this.allTags.filter(tag=> tag.name.includes(currentInp)).length===0) {
          this.selectedTags.push({ name : currentInp.trim()});
        }
      }
    }
    this.tagsInput.nativeElement.value='';


  }

  public addExpenseClickHandler() {
    let expenseToAdd = this.expenseService.getExpenseFromData(this.selectedTags, this.valueControl.value);
    this.expenseService.addExpense(null).subscribe(response=> {
      this.showAddExpenseModal();
      })
  }


  private showAddExpenseModal() {
    let dialogRef = this.dialog.open(AddedExpenseModalComponent, {
      width: '250px',
      data: {label : 'Success', content : 'Expense added successfully'}
    });
    dialogRef.afterClosed().subscribe(result=> {
      console.log('The dialog was closed');
    });
  }

  public selected(event: MatAutocompleteSelectedEvent) {
    
    let selectedTag = event.option.value;
    this.selectedTags.push(selectedTag);
    this.tagsInput.nativeElement.value = '';


  }

  public submitExpense(event: any) {
    console.log('submitExpense invoked');
  }


}
