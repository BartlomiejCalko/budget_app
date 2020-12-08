import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {

  public errorDisplayData: String;

  constructor(public dialogRef: MatDialogRef<HttpErrorResponse>,
    @Inject(MAT_DIALOG_DATA) public data: HttpErrorResponse) { }

  ngOnInit(): void {
    this.errorDisplayData = JSON.stringify(this.data);
  }

  public okClick() {
    this.dialogRef.close();
  }




}
