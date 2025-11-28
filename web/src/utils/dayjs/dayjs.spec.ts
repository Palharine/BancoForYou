import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Dayjs } from './dayjs';

describe('Dayjs', () => {
  let component: Dayjs;
  let fixture: ComponentFixture<Dayjs>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Dayjs]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Dayjs);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
