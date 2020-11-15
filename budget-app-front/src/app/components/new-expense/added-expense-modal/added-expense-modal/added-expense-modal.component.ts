import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-added-expense-modal',
  templateUrl: './added-expense-modal.component.html',
  styleUrls: ['./added-expense-modal.component.css']
})
export class AddedExpenseModalComponent {

  constructor(public dialogRef : MatDialogRef<AddedExpenseModalComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {

  }

  public okClick() {
    this.dialogRef.close();
  }


}
