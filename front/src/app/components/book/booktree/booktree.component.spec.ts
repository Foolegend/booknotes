import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BooktreeComponent } from './booktree.component';

describe('BooktreeComponent', () => {
  let component: BooktreeComponent;
  let fixture: ComponentFixture<BooktreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BooktreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BooktreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
