import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashListComponent } from './wash-list.component';

describe('WashListComponent', () => {
  let component: WashListComponent;
  let fixture: ComponentFixture<WashListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
