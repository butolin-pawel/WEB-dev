import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashUpdComponent } from './wash-upd.component';

describe('WashUpdComponent', () => {
  let component: WashUpdComponent;
  let fixture: ComponentFixture<WashUpdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashUpdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashUpdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
