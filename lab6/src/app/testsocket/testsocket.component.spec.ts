import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestsocketComponent } from './testsocket.component';

describe('TestsocketComponent', () => {
  let component: TestsocketComponent;
  let fixture: ComponentFixture<TestsocketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestsocketComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TestsocketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
