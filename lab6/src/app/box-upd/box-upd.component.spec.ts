import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxUpdComponent } from './box-upd.component';

describe('BoxUpdComponent', () => {
  let component: BoxUpdComponent;
  let fixture: ComponentFixture<BoxUpdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxUpdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BoxUpdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
