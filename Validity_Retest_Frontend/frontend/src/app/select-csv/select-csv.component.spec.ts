import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectCsvComponent } from './select-csv.component';

describe('SelectCsvComponent', () => {
  let component: SelectCsvComponent;
  let fixture: ComponentFixture<SelectCsvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectCsvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectCsvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
