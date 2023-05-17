import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsUpdComponent } from './cars-upd.component';

describe('CarsUpdComponent', () => {
  let component: CarsUpdComponent;
  let fixture: ComponentFixture<CarsUpdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarsUpdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarsUpdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
