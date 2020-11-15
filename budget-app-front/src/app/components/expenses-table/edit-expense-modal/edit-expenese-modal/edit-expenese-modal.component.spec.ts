import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditExpeneseModalComponent } from './edit-expenese-modal.component';

describe('EditExpeneseModalComponent', () => {
  let component: EditExpeneseModalComponent;
  let fixture: ComponentFixture<EditExpeneseModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditExpeneseModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditExpeneseModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
