import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashCarComponent } from './wash-car.component';

describe('WashCarComponent', () => {
  let component: WashCarComponent;
  let fixture: ComponentFixture<WashCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashCarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
