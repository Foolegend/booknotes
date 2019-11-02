import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookNotesComponent } from './booknotes.component';

describe('BookNotesComponent', () => {
  let component: BookNotesComponent;
  let fixture: ComponentFixture<BookNotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookNotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
